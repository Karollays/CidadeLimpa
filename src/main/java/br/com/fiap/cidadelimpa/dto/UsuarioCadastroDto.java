package br.com.fiap.cidadelimpa.dto;

import br.com.fiap.cidadelimpa.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(
        Long id,
        @NotBlank(message = "Nome é obrigatório")
        String nome,

//        @NotBlank(message = "CPF é obrigatório")
////      @Size(min = 11, max = 11, message = "O campo deve conter 11 caracteres")
//        String cpf,

        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail em formato inválido")
        String email,

        @NotBlank(message = "A senha é obrigatório")
        @Size(min = 6, max= 20, message = "A senha deve conter de 6 a 20 caracteres")
        String senha,

//        @NotNull(message = "Id do imóvel é obrigatório")
//        Long imovelId,

        UsuarioRole role
) {
}
