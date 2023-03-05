package com.example.demo.dao;

import com.example.demo.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    User getById(long id) throws SQLException;

    User getByUsername(String username) throws SQLException;

    List<User> getAll() throws SQLException;

    User save(User user) throws SQLException;

    void update(User user) throws SQLException;

    void delete(User user) throws SQLException;
}

