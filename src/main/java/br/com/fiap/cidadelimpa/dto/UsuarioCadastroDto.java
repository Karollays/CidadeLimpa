package br.com.fiap.cidadelimpa.dto;

import br.com.fiap.cidadelimpa.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(
        Long usuarioId,

        @NotBlank(message = "O nome do usuário é obrigatório!")
                String nome,

        @NotBlank(message = "O email do usuário é obrigatório!")
        @Email(message = "O email do usuário não é válido!")
        String email,

        @NotBlank(message = "A senha é obrigatório")
        @Size(min = 6, max= 20, message = "A senha deve conter de 6 a 20 caracteres")
        String senha,
        UsuarioRole role


) {
}
