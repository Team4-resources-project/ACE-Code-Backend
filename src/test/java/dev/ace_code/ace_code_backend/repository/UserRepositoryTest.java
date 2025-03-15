package dev.ace_code.ace_code_backend.repository;

import dev.ace_code.ace_code_backend.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        User user = new User("testuser", "password");
        entityManager.persist(user);
        entityManager.flush();

        User foundUser = userRepository.findByUsername("testuser");

        assertNotNull(foundUser);
        assertEquals("testuser", foundUser.getUsername());
        assertEquals("password", foundUser.getPassword());
    }

    @Test
    public void testFindByUsernameNotFound() {
        User foundUser = userRepository.findByUsername("nonexistentuser");
        assertNull(foundUser);
    }
}