package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
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
    public User createUser(User user) throws SQLException {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        User savedUser;
        try {
            savedUser = userDao.save(user);
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
    public User updateUser(User user) throws SQLException {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        try {
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("Unable to save user to database!", e);
        }
        return user;
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
