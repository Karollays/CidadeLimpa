package br.com.fiap.cidadelimpa.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ImovelCadastroDto(
        Long id,
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Rua é obrigatório")
        String rua,
        @NotBlank(message = "Bairro é obrigatório")
        String bairro,
        @NotNull(message = "Lixo reciclável é obrigatório")
        @Digits(integer = 2, fraction = 2)
        @PositiveOrZero(message = "Lixo reciclável não pode ser negativo")
        Double reciclavel,
        @NotNull(message = "Lixo orgânico é obrigatório")
        @Digits(integer = 2, fraction = 2)
        @PositiveOrZero(message = "Lixo orgânico não pode ser negativo")
        Double organico
) {
}
