package com.example.demo.service;

import com.example.demo.dto.userdto.CreateUserDto;
import com.example.demo.dto.userdto.UpdateUserDto;
import com.example.demo.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User createUser(CreateUserDto createUserDto) throws SQLException;

    User updateUser(UpdateUserDto updateUserDto) throws SQLException;

    User getUserById(Long id);

    List<User> getAllUsers() throws SQLException;

    void deleteUserById(Long id) throws SQLException;

}