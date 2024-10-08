package br.com.fiap.cidadelimpa.dto;

import br.com.fiap.cidadelimpa.model.Usuario;
import br.com.fiap.cidadelimpa.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
//        String cpf,
        String email,
//        Long imovelId,
//        String nomeImovel,
//        String rua,
//        String bairro,
        UsuarioRole role
) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
//                usuario.getCpf(),
                usuario.getEmail(),
//                usuario.getImovel().getId(),
//                usuario.getImovel().getNome(),
//                usuario.getImovel().getRua(),
//                usuario.getImovel().getBairro(),
                usuario.getRole());
    }
}
