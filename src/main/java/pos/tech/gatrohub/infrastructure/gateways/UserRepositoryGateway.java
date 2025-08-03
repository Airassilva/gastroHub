package pos.tech.gatrohub.infrastructure.gateways;


import pos.tech.gatrohub.application.gateways.UserGateway;
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
    public Optional<User> buscarPorLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> buscarPorId(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void salvar(User user) {
        userRepository.save(user);
    }
}
