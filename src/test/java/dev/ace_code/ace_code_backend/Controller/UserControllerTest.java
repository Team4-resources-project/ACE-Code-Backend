package dev.ace_code.ace_code_backend.controller;

import dev.ace_code.ace_code_backend.Controller.UserController;
import dev.ace_code.ace_code_backend.model.User;
import dev.ace_code.ace_code_backend.model.UserDTO;
import dev.ace_code.ace_code_backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(
                new User("user1", "pass1"),
                new User("user2", "pass2")
        );
        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<User>> response = userController.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetUserByIdFound() {
        User user = new User("testuser", "password");
        when(userService.getUserById(1L)).thenReturn(user);

        ResponseEntity<User> response = userController.getUserById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetUserByIdNotFound() {
        when(userService.getUserById(1L)).thenReturn(null);

        ResponseEntity<User> response = userController.getUserById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testuser");
        userDTO.setPassword("password");

        User savedUser = new User("testuser", "password");
        when(userService.saveUser(any(User.class))).thenReturn(savedUser);

        ResponseEntity<User> response = userController.createUser(userDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testDeleteUser() {
        ResponseEntity<String> response = userController.deleteUser(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Usuario eliminado correctamente.", response.getBody());
        verify(userService, times(1)).deleteUser(1L);
    }

    @Test
    public void testLoginSuccess() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testuser");
        userDTO.setPassword("password");

        when(userService.login("testuser", "password")).thenReturn(true);

        ResponseEntity<String> response = userController.login(userDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Login exitoso", response.getBody());
    }

    @Test
    public void testLoginFailure() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testuser");
        userDTO.setPassword("wrongpassword");

        when(userService.login("testuser", "wrongpassword")).thenReturn(false);

        ResponseEntity<String> response = userController.login(userDTO);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Usuario o contraseña incorrectos", response.getBody());
    }
}