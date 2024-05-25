package br.com.fiap.cidadelimpa.dto;

import br.com.fiap.cidadelimpa.model.Usuario;
import br.com.fiap.cidadelimpa.model.UsuarioRole;

public record UsuarioExibicaoDto(

        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role
) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()
);
    }
}
