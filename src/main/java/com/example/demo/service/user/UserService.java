package com.example.demo.service.user;

import com.example.demo.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User createUser(User user) throws SQLException;
    User updateUser(User user) throws SQLException;
    User getUserById(Long id);
    List<User> getAllUsers() throws SQLException;
    boolean deleteUserById(Long id) throws SQLException;
}