package pos.tech.gatrohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pos.tech.gatrohub.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
