package br.com.fiap.cidadelimpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ColetaCadastroDto(
        Long id,
        @NotNull(message = "Data da coleta é obrigatório")
        LocalDate dataColeta,
        @NotBlank(message = "Tipo da coleta é obrigatório")
        String tipoColeta,
        @NotNull(message = "Id do caminhão é obrigatório")
        Long caminhaoId,
        @NotNull(message = "Id do imóvel é obrigatório")
        Long imovelId
) {
}
