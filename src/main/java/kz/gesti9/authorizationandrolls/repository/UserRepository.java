package kz.gesti9.authorizationandrolls.repository;

import kz.gesti9.authorizationandrolls.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
