package dev.ace_code.ace_code_backend.repository;

import dev.ace_code.ace_code_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
