package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.daoimpl.UserDaoImpl;
import com.example.demo.dto.userdto.CreateUserDto;
import com.example.demo.dto.userdto.UpdateUserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.service.UserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final Validator validator;
    @Autowired
    public UserServiceImpl(UserDao userDao, Validator validator) {
        this.userDao = userDao;
        this.validator = validator;
    }
    @Override
    public User createUser(CreateUserDto createUserDto) throws SQLException {
        Set<ConstraintViolation<CreateUserDto>> violations = validator.validate(createUserDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        User savedUser = null;
        try {
            savedUser = userDao.save(new User(createUserDto));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("Unable to save user to database!", e);
        }
        return savedUser;
    }
    @Override
    public User updateUser(UpdateUserDto updateUserDto) throws SQLException {
        Set<ConstraintViolation<UpdateUserDto>> violations = validator.validate(updateUserDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        User updatedUser = new User(updateUserDto);
        try {
            userDao.update(updatedUser);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("Unable to save user to database!", e);
        }
        return updatedUser;
    }
    @Override
    public User getUserById(Long id) {
        Set<ConstraintViolation<Long>> violations = validator.validate(id);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        User user = null;
        try {
            user = userDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("Unable to save user to database!", e);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAll();
    }

    @Override
    public void deleteUserById(Long id) throws SQLException {
        userDao.delete(id);
    }
}
