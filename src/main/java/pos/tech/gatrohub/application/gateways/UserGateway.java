package pos.tech.gatrohub.application.gateways;


import pos.tech.gatrohub.infrastructure.persistence.User;
import java.util.Optional;

public interface UserGateway {
    Optional<User> buscarPorLoginESenha(String login, String senha);
    Optional<User> buscarPorLogin(String login);
    Optional<User> buscarPorId(Long id);
    void salvar(User user);
}
