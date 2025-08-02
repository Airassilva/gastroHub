package pos.tech.gatrohub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pos.tech.gatrohub.entity.Endereco;

@Getter
public record UserUpdateRequestDTO(
        @NotNull
        Long id,

        @Email
        String email,

        @NotNull
        Endereco endereco) {
}
