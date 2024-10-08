package br.com.fiap.cidadelimpa.dto;

import jakarta.validation.constraints.*;

public record CaminhaoCadastroDto(
        Long id,
        @NotBlank(message = "Registro é obrigatório")
        String registro,
        @NotNull(message = "Capacidade é obrigatório")
        @Digits(integer = 3, fraction = 2)
        @PositiveOrZero(message = "Capacidade não pode ser negativo")
        Double capacidade
) {
}
