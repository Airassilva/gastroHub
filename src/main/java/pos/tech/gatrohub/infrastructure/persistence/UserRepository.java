package pos.tech.gatrohub.infrastructure.persistence;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLoginAndSenha(String login, String senha);

    Optional<User> getReferenceById(@NotNull Long id);

    Page<User> findAllByAtivoTrue(Pageable pageable);
}
