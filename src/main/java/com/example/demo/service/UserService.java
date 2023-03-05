package com.example.demo.service;

import com.example.demo.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User createUser(User user) throws SQLException;
    User updateUser(User user) throws SQLException;
    User getUserById(Long id);
    List<User> getAllUsers() throws SQLException;
    void deleteUserById(Long id) throws SQLException;
}