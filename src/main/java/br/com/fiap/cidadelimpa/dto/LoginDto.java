package br.com.fiap.cidadelimpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(
        @NotBlank(message = "O email do morador é obrigatório!")
        @Email(message = "O email não é válido")
        String email,

        @NotBlank
        @Size(min = 6, max = 20, message = "A senha deve conter de 6 a 20 caracteres")
        String senha


) {
}
