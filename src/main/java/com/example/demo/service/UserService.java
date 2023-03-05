package com.example.demo.service;

import com.example.demo.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User createUser(User user) throws SQLException;

    User updateUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUserById(Long id);

}