package dev.ace_code.ace_code_backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testConstructorAndGetters() {
        User user = new User("testuser", "password123");

        assertNull(user.getId());
        assertEquals("testuser", user.getUsername());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testSetters() {
        User user = new User();
        user.setUsername("newuser");
        user.setPassword("newpassword");

        assertEquals("newuser", user.getUsername());
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testEmptyConstructor() {
        User user = new User();

        assertNull(user.getId());
        assertNull(user.getUsername());
        assertNull(user.getPassword());
    }

    @Test
    public void testIdGeneration() {
        User user = new User("testuser", "password123");
        assertNull(user.getId());
    }
}