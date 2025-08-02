package pos.tech.gatrohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pos.tech.gatrohub.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
