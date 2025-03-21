package dev.ace_code.ace_code_backend.service;

import dev.ace_code.ace_code_backend.model.User;
import dev.ace_code.ace_code_backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers_ShouldReturnUserList() {
        List<User> users = Arrays.asList(new User("user1", "pass1"), new User("user2", "pass2"));
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(2, result.size());
    }

    @Test
    void getUserById_ShouldReturnUser_WhenUserExists() {
        User user = new User("user1", "pass1");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals("user1", result.getUsername());
    }

    @Test
    void getUserById_ShouldReturnNull_WhenUserNotExists() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        User result = userService.getUserById(1L);
        assertNull(result);
    }

    @Test
    void saveUser_ShouldSaveAndReturnUser() {
        User user = new User("user1", "pass1");
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.saveUser(user);
        assertNotNull(result);
        assertEquals("user1", result.getUsername());
    }

    @Test
    void deleteUser_ShouldCallRepositoryDelete() {
        Long userId = 1L;
        doNothing().when(userRepository).deleteById(userId);

        userService.deleteUser(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }
    @Test
    void login_ShouldReturnTrue_WhenCredentialsAreCorrect() {
        User user = new User("user1", "pass1");
        when(userRepository.findByUsername("user1")).thenReturn(user);

        boolean result = userService.login("user1", "pass1");
        assertTrue(result);
    }

    @Test
    void login_ShouldReturnFalse_WhenUserNotFound() {
        when(userRepository.findByUsername("user1")).thenReturn(null);

        boolean result = userService.login("user1", "pass1");
        assertFalse(result);
    }

    @Test
    void login_ShouldReturnFalse_WhenPasswordIsIncorrect() {
        User user = new User("user1", "pass1");
        when(userRepository.findByUsername("user1")).thenReturn(user);

        boolean result = userService.login("user1", "wrongpass");
        assertFalse(result);
    }
}
