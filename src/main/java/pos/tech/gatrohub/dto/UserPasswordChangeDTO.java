package pos.tech.gatrohub.dto;

import jakarta.validation.constraints.NotBlank;

public record UserPasswordChangeDTO(
        @NotBlank
        String login,

        @NotBlank
        String senha) {
}
