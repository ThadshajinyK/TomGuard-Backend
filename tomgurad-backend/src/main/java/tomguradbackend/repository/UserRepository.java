package tomguradbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tomguradbackend.entity.User;

public interface   UserRepository extends JpaRepository<User , Long> {
    Boolean existsByEmail(String email);
    User findByEmail(String email);

    User findByResetToken(String token);

}
