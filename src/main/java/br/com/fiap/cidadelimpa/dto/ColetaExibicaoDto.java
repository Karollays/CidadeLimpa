package br.com.fiap.cidadelimpa.dto;

import br.com.fiap.cidadelimpa.model.Coleta;
import java.time.LocalDate;

public record ColetaExibicaoDto(
        Long id,
        LocalDate dataColeta,
        String tipoColeta,
        Long caminhaoId,
        Long imovelId
) {
    public ColetaExibicaoDto(Coleta coleta) {
        this(coleta.getId(), coleta.getDataColeta(), coleta.getTipoColeta(),
                coleta.getCaminhao().getId(), coleta.getImovel().getId());
    }
}