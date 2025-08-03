package pos.tech.gatrohub.domain.entity;

import pos.tech.gatrohub.infrastructure.persistence.Endereco;

public record UserUpdateRequestDTO(
        Long id,

        String email,

        Endereco endereco) {
}
