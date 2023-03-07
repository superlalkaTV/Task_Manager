package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.user.UserService;
import com.example.demo.service.user.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    private final UserService userService;
    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Void> registerUserAccount(@Valid @RequestBody User user,
                                                    HttpServletRequest request){
//        userService.createUser()



        return null;
    }


}
