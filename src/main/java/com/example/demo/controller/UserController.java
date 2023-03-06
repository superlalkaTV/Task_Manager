package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        try {
            userService.createUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        user.setId(id);

        User returnUser;
        try {
            returnUser = userService.updateUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(returnUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (id > 0) {
            try {
                if (userService.deleteUserById(id))
                    return ResponseEntity.noContent().build();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users;
        try {
            users = userService.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(users);
    }

}
