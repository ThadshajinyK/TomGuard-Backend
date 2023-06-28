package com.TomGuard.Repository;

import com.TomGuard.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
//    User findByEmail(String email);

    User findByEmail(String email);

    User findByResetToken(String token);


}
