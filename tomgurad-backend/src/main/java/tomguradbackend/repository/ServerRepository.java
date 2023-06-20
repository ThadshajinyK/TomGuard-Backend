package tomguradbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tomguradbackend.entity.Server;

public interface ServerRepository extends JpaRepository<Server ,Integer> {
}
