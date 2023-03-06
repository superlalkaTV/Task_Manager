package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    private Validator validator;
    @Mock
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();

        userService = new UserServiceImpl(userDao,validator);
    }

    @Test
    void createUser() {
        User createUserDto = new User(1L,"John","asd@asd.asd","Qwerty123!");

        User user = null;
        try {
            user = userService.createUser(createUserDto);
        } catch (SQLException e) {
            fail();
        }

        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals("John", user.getUsername());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("Qwerty123!",user.getEmail());
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void deleteUserById() {
    }
}