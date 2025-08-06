package pos.tech.gatrohub.application.gateways;


import pos.tech.gatrohub.domain.entity.ParametrosPaginacao;
import pos.tech.gatrohub.domain.entity.ResultadoPaginado;
import pos.tech.gatrohub.infrastructure.persistence.User;
import java.util.Optional;

public interface UserGateway {
    Optional<User> buscarPorLoginESenha(String login, String senha);
    Optional<User> buscarPorId(Long id);
    void salvar(User user);
    ResultadoPaginado<User> buscarUsuariosAtivos(ParametrosPaginacao parametros);
}
