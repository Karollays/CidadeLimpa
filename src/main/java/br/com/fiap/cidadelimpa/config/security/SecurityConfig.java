package br.com.fiap.cidadelimpa.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private VerificarToken verificarToken;

    @Bean
    public SecurityFilterChain filtrarCadeiaDeSegurança(

            HttpSecurity httpSecurity) throws Exception{

        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        // Acionando a consulta GET para qualquer pessoa
//                        .requestMatchers(HttpMethod.GET, "/api/contatos")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated())
                        // Acionando a gravação POST para usuários ADMIN
                          .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                          .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                          .requestMatchers(HttpMethod.GET, "/api/contatos").hasAnyRole("ADMIN", "USER") // Pode adicionar mais "MANAGER", etc
                          .requestMatchers(HttpMethod.POST, "/api/contatos").hasRole("ADMIN") // Pode adicionar mais "MANAGER", etc
                          .requestMatchers(HttpMethod.PUT, "/api/contatos").hasRole("ADMIN")
                          .requestMatchers(HttpMethod.DELETE, "/api/contatos").hasRole("ADMIN")
                          .anyRequest()
                          .authenticated())
                .addFilterBefore(
                        verificarToken,
                        UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
