package br.com.fiap.cidadelimpa.dto;

import br.com.fiap.cidadelimpa.model.Morador;

public record MoradorExibicaoDto(
        Long id,
        String nome,
        String cpf,
        String email,
        Long imovelId,
        String nomeImovel,
        String rua,
        String bairro
) {
    public MoradorExibicaoDto(Morador morador) {
        this(morador.getId(), morador.getNome(), morador.getCpf(), morador.getEmail(),
                morador.getImovel().getId(), morador.getImovel().getNome(),
                morador.getImovel().getRua(), morador.getImovel().getBairro());
    }
}
