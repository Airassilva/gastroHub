package pos.tech.gatrohub.repository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pos.tech.gatrohub.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLoginAndSenha(String login, String senha);

    Optional<User> findByLogin(String login);

    Optional<User> findById(@NotNull Long id);
}
