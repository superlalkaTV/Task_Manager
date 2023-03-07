package com.example.demo.dao.daoimpl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String GET_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM users";
    private static final String SAVE_USER = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE users SET username = ?, password = ?, email = ? WHERE id = ?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getById(long id) throws SQLException{
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, new Object[]{id}, new UserRowMapper());
    }

    @Override
    public User getByUsername(String username) throws SQLException{
        return jdbcTemplate.queryForObject(GET_USER_BY_USERNAME, new Object[]{username}, new UserRowMapper());
    }

    @Override
    public List<User> getAll() throws SQLException{
        return jdbcTemplate.query(GET_ALL_USERS, new UserRowMapper());
    }

    @Override
    public User save(User user) throws SQLException{
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(SAVE_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            return ps;
        }, keyHolder);
        long userId =Objects.requireNonNull(keyHolder.getKey()).longValue();
        user.setId(userId);
        return user;
    }

    @Override
    public void update(User user) throws SQLException{
        jdbcTemplate.update(UPDATE_USER, user.getUsername(), user.getPassword(), user.getEmail(), user.getId());
    }

    @Override
    public int delete(long id) throws SQLException{
        return jdbcTemplate.update(DELETE_USER_BY_ID, id);
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            long id = resultSet.getLong("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");

            return new User(id, username, password, email);
        }
    }
}
