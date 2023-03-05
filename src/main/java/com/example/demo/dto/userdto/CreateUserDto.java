package com.example.demo.dto.userdto;

import com.example.demo.util.validator.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserDto {
    @NotBlank(message = "Username is required")
    @Size(max = 50, message = "Username cannot be longer than 50 characters")
    private String username;
    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is mandatory")
    private String email;
    @ValidPassword
    private String password;
    public CreateUserDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
