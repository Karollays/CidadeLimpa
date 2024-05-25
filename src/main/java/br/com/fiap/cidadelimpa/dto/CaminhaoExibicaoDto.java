package br.com.fiap.cidadelimpa.dto;

import br.com.fiap.cidadelimpa.model.Caminhao;

public record CaminhaoExibicaoDto(
        Long id,
        String registro,
        Double capacidade
) {
    public CaminhaoExibicaoDto(Caminhao caminhao) {
        this(caminhao.getId(), caminhao.getRegistro(), caminhao.getCapacidade());
    }
}