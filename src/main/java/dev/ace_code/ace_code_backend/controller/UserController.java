package dev.ace_code.ace_code_backend.controller;

import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;

import dev.ace_code.ace_code_backend.model.User;
import dev.ace_code.ace_code_backend.model.UserDTO;
import dev.ace_code.ace_code_backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id) != null ? 
                ResponseEntity.ok(userService.getUserById(id)) : 
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getPassword());
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Usuario eliminado correctamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserDTO userDTO) {
    boolean success = userService.login(userDTO.getUsername(), userDTO.getPassword());
    if (success) {
        String token = JWT.create()
                .withSubject(userDTO.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                .sign(Algorithm.HMAC512("secret".getBytes()));

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("message", "Inicio de sesión exitoso");

        return ResponseEntity.ok(response);
    } else {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario o contraseña incorrectos");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}

@PostMapping("/register")
public ResponseEntity<Map<String, String>> register(@RequestBody UserDTO userDTO) {
    boolean success = userService.register(userDTO.getUsername(), userDTO.getPassword());
    if (success) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario registrado correctamente.");
        return ResponseEntity.ok(response);
    } else {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Error al registrar el usuario.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
}
