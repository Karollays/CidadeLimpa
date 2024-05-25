package br.com.fiap.cidadelimpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MoradorCadastroDto(
        Long id,
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "CPF é obrigatório")
        @Size(min = 11, max = 11, message = "O campo deve conter 11 caracteres")
        String cpf,
        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail em formato inválido")
        String email,
        @NotNull(message = "Id do imóvel é obrigatório")
        Long imovelId
) {
}
