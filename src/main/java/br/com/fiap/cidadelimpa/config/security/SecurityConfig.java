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
//                        .requestMatchers(HttpMethod.GET, "/api/moradores")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated()
//                        )
                                 //Acionando a gravação POST para usuários ADMIN
                                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()

                                // Usuario
                                .requestMatchers(HttpMethod.GET, "/api/usuarios").hasAnyRole("ADMIN", "USER") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.POST, "/api/usuarios").hasRole("ADMIN") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.PUT, "/api/usuarios").hasRole("ADMIN")
                                //.requestMatchers(HttpMethod.DELETE, "/api/usuarios").hasRole("ADMIN").anyRequest().authenticated()

//                                // Morador
                                .requestMatchers(HttpMethod.GET, "/api/moradores").hasAnyRole("ADMIN", "USER") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.POST, "/api/moradores").hasRole("ADMIN") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.PUT, "/api/moradores").hasRole("ADMIN")
                                //.requestMatchers(HttpMethod.DELETE, "/api/moradores").hasRole("ADMIN").anyRequest().authenticated()



//                                // Data da Coleta
                                .requestMatchers(HttpMethod.GET, "/api/coletas").hasAnyRole("ADMIN", "USER") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.POST, "/api/coletas").hasRole("ADMIN") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.PUT, "/api/coletas").hasRole("ADMIN")
                                //.requestMatchers(HttpMethod.DELETE, "/api/coletas").hasRole("ADMIN").anyRequest().authenticated()

                                // Imovel

                                .requestMatchers(HttpMethod.GET, "/api/imoveis").hasAnyRole("ADMIN", "USER") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.POST, "/api/imoveis").hasRole("ADMIN") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.PUT, "/api/imoveis").hasRole("ADMIN")
                                //.requestMatchers(HttpMethod.DELETE, "/api/imoveis").hasRole("ADMIN").anyRequest().authenticated()

//                                // Caminhão
//
                                .requestMatchers(HttpMethod.GET, "/api/caminhoes").hasAnyRole("ADMIN", "USER") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.POST, "/api/caminhoes").hasRole("ADMIN") // Pode adicionar mais "MANAGER", etc
                                .requestMatchers(HttpMethod.PUT, "/api/caminhoes").hasRole("ADMIN")

                                // .anyRequest.authenticate sempre deverá ser o último após os .requestMatchers e rodar em uma linha só
//                                .requestMatchers(HttpMethod.DELETE,
//                                "/api/usuarios",
//                                "/api/moradores",
//                                "/api/caminhoes",
//                                "/api/coletas",
//                                "/api/imoveis")
//                                .hasRole("ADMIN").anyRequest().authenticated()

                                //Apenas para Usuário
                                  .requestMatchers(HttpMethod.DELETE, "/api").hasRole("ADMIN").anyRequest().authenticated()
//                                .requestMatchers(HttpMethod.DELETE, "/api/usuarios", "/api/moradores", "/api/coletas", "/api/caminhoes").hasRole("ADMIN").anyRequest().authenticated()

                )



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