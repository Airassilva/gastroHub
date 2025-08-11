package pos.tech.gatrohub.application.dto;

import pos.tech.gatrohub.infrastructure.persistence.Endereco;

public record UserUpdateEndereco(
        Long id_usuario,
        Endereco endereco) {
}
