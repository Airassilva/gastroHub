package pos.tech.gatrohub.domain.entity;

import pos.tech.gatrohub.infrastructure.persistence.TipoUsuario;
import pos.tech.gatrohub.infrastructure.persistence.User;

public record UserRequestDTO(
        String nome,

        String email,

        String cpf,

        String cnpj,

        String login,

        String senha,

        TipoUsuario tipoUsuario,

        EnderecoDTO endereco) {

    public UserRequestDTO( User user) {
        this(
                user.getNome(),
                user.getEmail(),
                user.getCpf(),
                user.getCnpj(),
                user.getLogin(),
                user.getSenha(),
                user.getTipoUsuario(),
                new EnderecoDTO(user.getEndereco())
        );
    }
}
