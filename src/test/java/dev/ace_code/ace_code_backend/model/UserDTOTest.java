package dev.ace_code.ace_code_backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDTOTest {

    @Test
    public void testConstructorAndGetters() {
        UserDTO userDTO = new UserDTO("testuser", "password123");

        assertEquals("testuser", userDTO.getUsername());
        assertEquals("password123", userDTO.getPassword());
    }

    @Test
    public void testSetters() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("newuser");
        userDTO.setPassword("newpassword");

        assertEquals("newuser", userDTO.getUsername());
        assertEquals("newpassword", userDTO.getPassword());
    }

    @Test
    public void testEmptyConstructor() {
        UserDTO userDTO = new UserDTO();

        assertNull(userDTO.getUsername());
        assertNull(userDTO.getPassword());
    }
}