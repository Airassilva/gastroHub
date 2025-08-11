package pos.tech.gatrohub.application.dto;

import pos.tech.gatrohub.infrastructure.persistence.Endereco;

public record UserUpdateRequestDTO(
        Long id,

        String email,

        Endereco endereco) {
}
