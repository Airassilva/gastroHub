package pos.tech.gatrohub.domain.entity;

import pos.tech.gatrohub.infrastructure.persistence.Endereco;

public record UserUpdateEndereco(
        Long id_usuario,
        Endereco endereco) {
}
