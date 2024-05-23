package br.com.fiap.cidadelimpa.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbl_usuarios")
@Getter //Usando o Lombok
@Setter //Usando o Lombok
@NoArgsConstructor // Usando o Lombok
@AllArgsConstructor // Usando o Lombok
@EqualsAndHashCode // Usando o Lombok

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "USUARIOS_SEQ"
    )
    @SequenceGenerator(
            name = "USUARIOS_SEQ",
            sequenceName = "USUARIOS_SEQ",
            allocationSize = 1
    )
    @Column(name = "usuario_id")
    private Long usuarioId;

    private String nome;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private UsuarioRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UsuarioRole.ADMIN){
        return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER")
        );
    } else {
            return List.of(
                    new SimpleGrantedAuthority(("ROLE_USER"))
            );
        }
    }


    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
