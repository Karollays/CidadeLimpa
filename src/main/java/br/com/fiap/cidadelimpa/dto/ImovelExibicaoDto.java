package br.com.fiap.cidadelimpa.dto;

import br.com.fiap.cidadelimpa.model.Imovel;
import java.util.List;
import java.util.stream.Collectors;

public record ImovelExibicaoDto(
        Long id,
        String nome,
        String rua,
        String bairro,
        Double reciclavel,
        Double organico,
        List<Long> moradoresIds
) {
    public ImovelExibicaoDto(Imovel imovel) {
        this(imovel.getId(), imovel.getNome(), imovel.getRua(), imovel.getBairro(),
                imovel.getReciclavel(), imovel.getOrganico(),
                imovel.getMoradores().stream().map(morador -> morador.getId()).collect(Collectors.toList()));
    }
}