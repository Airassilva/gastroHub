package pos.tech.gatrohub.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import pos.tech.gatrohub.entity.TipoUsuario;

public record UserRequestDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @CPF
        String cpf,

        @CNPJ
        String cnpj,

        @NotBlank
        String login,

        @NotBlank
        String senha,

        @NotNull
        TipoUsuario tipoUsuario,

        @NotNull
        @Valid
        EnderecoDTO endereco) {
}
