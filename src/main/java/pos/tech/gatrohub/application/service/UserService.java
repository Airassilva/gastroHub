package pos.tech.gatrohub.application.service;

import pos.tech.gatrohub.application.gateways.EnderecoGateway;
import pos.tech.gatrohub.application.gateways.UserGateway;
import pos.tech.gatrohub.domain.entity.UserPasswordChangeDTO;
import pos.tech.gatrohub.domain.entity.UserRequestDTO;
import pos.tech.gatrohub.domain.entity.UserUpdateRequestDTO;
import pos.tech.gatrohub.infrastructure.gateways.EnderecoMapper;
import pos.tech.gatrohub.infrastructure.gateways.UserMapper;
import pos.tech.gatrohub.infrastructure.persistence.Endereco;
import pos.tech.gatrohub.infrastructure.persistence.User;

import java.util.Optional;

public class UserService {

    private final UserGateway userGateway;
    private final EnderecoGateway enderecoGateway;
    private final UserMapper userMapper;
    private final EnderecoMapper enderecoMapper;

    public UserService(UserGateway userGateway,
                       EnderecoGateway enderecoGateway,
                       UserMapper userMapper,
                       EnderecoMapper enderecoMapper) {
        this.userGateway = userGateway;
        this.enderecoGateway = enderecoGateway;
        this.userMapper = userMapper;
        this.enderecoMapper = enderecoMapper;
    }

    public void cadastrarUsuario(UserRequestDTO requestDTO) {
        Endereco endereco = enderecoMapper.toEntity(requestDTO.endereco());
        Endereco enderecoSalvo = enderecoGateway.salvar(endereco);

        User user = userMapper.toEntity(requestDTO);
        user.setEndereco(enderecoSalvo);

        userGateway.salvar(user);
    }

    public void login(UserPasswordChangeDTO loginDTO) {
        Optional<User> optionalUser =
                userGateway.buscarPorLoginESenha(loginDTO.login(), loginDTO.senha());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Login ou senha inválidos.");
        }
    }

    public void trocarSenha(UserPasswordChangeDTO dto) {
        User user = userGateway.buscarPorLogin(dto.login())
                .orElseThrow(() -> new RuntimeException("Login não encontrado."));

        user.setSenha(dto.senha());
        userGateway.salvar(user);
    }

    public void atualizarUsuario(UserUpdateRequestDTO dto) {
        User user = userGateway.buscarPorId(dto.id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado no sistema"));

        user.setEmail(dto.email());
        user.setEndereco(dto.endereco());
        userGateway.salvar(user);
    }

    public void deletarUsuario(UserPasswordChangeDTO dto) {
        User user = userGateway.buscarPorLoginESenha(dto.login(), dto.senha())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado para exclusão"));

        user.setAtivo(false);
        userGateway.salvar(user);
    }
}
