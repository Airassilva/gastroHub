package pos.tech.gatrohub.infrastructure.gateways;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pos.tech.gatrohub.application.gateways.UserGateway;
import pos.tech.gatrohub.domain.entity.ParametrosPaginacao;
import pos.tech.gatrohub.domain.entity.ResultadoPaginado;
import pos.tech.gatrohub.infrastructure.persistence.User;
import pos.tech.gatrohub.infrastructure.persistence.UserRepository;

import java.util.Optional;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;

    public UserRepositoryGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> buscarPorLoginESenha(String login, String senha) {
        return userRepository.findByLoginAndSenha(login, senha);
    }

    @Override
    public Optional<User> buscarPorId(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void salvar(User user) {
        userRepository.save(user);
    }

    @Override
    public ResultadoPaginado<User> buscarUsuariosAtivos(ParametrosPaginacao parametros) {
        Pageable pageable = PageRequest.of(parametros.getPagina(), parametros.getTamanho());
        Page<User> paginaSpring = userRepository.findAllByAtivoTrue(pageable);

        return new ResultadoPaginado<>(
                paginaSpring.getContent(),
                paginaSpring.getNumber(),
                paginaSpring.getTotalPages(),
                paginaSpring.getTotalElements()
        );
    }
}
