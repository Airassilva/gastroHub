package pos.tech.gatrohub.domain.entity;

import pos.tech.gatrohub.infrastructure.persistence.TipoUsuario;

public record UserRequestDTO(
        String nome,

        String email,

        String cpf,

        String cnpj,

        String login,

        String senha,

        TipoUsuario tipoUsuario,

        EnderecoDTO endereco) {

}
