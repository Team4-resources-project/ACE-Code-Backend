package dev.ace_code.ace_code_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // Cambiado de 'user' a 'username'
    private String password;

    public User() {}

    public User(String username, String password) { // Cambiado 'user' a 'username'
        this.username = username; // Cambiado 'user' a 'username'
        this.password = password;
    }

    public Long getId() { return id; }

    public String getUsername() { return username; } // Cambiado 'getUser' a 'getUsername'
    public void setUsername(String username) { this.username = username; } // Cambiado 'setUser' a 'setUsername'

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}