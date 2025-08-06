package pos.tech.gatrohub.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pos.tech.gatrohub.application.gateways.EnderecoGateway;
import pos.tech.gatrohub.application.gateways.UserGateway;
import pos.tech.gatrohub.domain.entity.*;
import pos.tech.gatrohub.infrastructure.gateways.EnderecoMapper;
import pos.tech.gatrohub.infrastructure.gateways.UserMapper;
import pos.tech.gatrohub.infrastructure.persistence.Endereco;
import pos.tech.gatrohub.infrastructure.persistence.User;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        if ((requestDTO.cpf() == null || requestDTO.cpf().isBlank()) &&
                (requestDTO.cnpj() == null || requestDTO.cnpj().isBlank())) {
            throw new RuntimeException("Precisa ser informado um CPF ou CNPJ.");
        }

        Endereco endereco = EnderecoMapper.toEntity(requestDTO.endereco());
        Endereco enderecoSalvo = enderecoGateway.salvar(endereco);

        User user = UserMapper.toEntity(requestDTO);
        user.setEndereco(Collections.singletonList(enderecoSalvo));

        userGateway.salvar(user);
    }

    public UserResponseDTO login(LoginDTO loginDTO) {
        Optional<User> optionalUser =
                userGateway.buscarPorLoginESenha(loginDTO.login(), loginDTO.senha());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Login ou senha inválidos.");
        }
        User user = optionalUser.get();
        return userMapper.toDTO(user);
    }

    public void trocarSenha(UserPasswordChangeDTO dto) {
        User user = userGateway.buscarPorId(dto.id())
                .orElseThrow(() -> new RuntimeException("Login não encontrado."));

        if (!dto.senhaAntiga().equals(user.getSenha())) {
            throw new RuntimeException("A senha antiga está incorreta.");
        }

        if (dto.senhaNova().equals(user.getSenha())) {
            throw new RuntimeException("A nova senha não pode ser igual à senha atual.");
        }
        user.setSenha(dto.senhaNova());
        user.setDataUltimaAlteracao(new Date());
        userGateway.salvar(user);
    }

    public void atualizarUsuario(UserUpdateRequestDTO dto) {
        User user = userGateway.buscarPorId(dto.id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado no sistema"));

        user.setEmail(dto.email());
        user.setEndereco(Collections.singletonList(dto.endereco()));
        user.setDataUltimaAlteracao(new Date());
        userGateway.salvar(user);
    }

    public void atualizarEnderecoUsuario(UserUpdateEndereco dto) {
       User user = userGateway.buscarPorId(dto.id_usuario())
               .orElseThrow(() -> new RuntimeException("Usuario não encontrado no sistema"));
       user.setEndereco(Collections.singletonList(dto.endereco()));
       user.setDataUltimaAlteracao(new Date());
       userGateway.salvar(user);
    }

    public void deletarUsuario(Long id) {
        User user = userGateway.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado para exclusão"));
        user.setAtivo(false);
        user.setDataUltimaAlteracao(new Date());
        userGateway.salvar(user);
    }

    public Page<UserResponseDTO> buscarUsuariosAtivos(Pageable pageable) {
        ParametrosPaginacao parametros = new ParametrosPaginacao(pageable.getPageNumber(), pageable.getPageSize());

        ResultadoPaginado<User> resultado = userGateway.buscarUsuariosAtivos(parametros);

        List<UserResponseDTO> dtos = resultado.getItens().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, resultado.getTotalElementos());
    }
}
