package com.example.demo.dto.userdto;

import com.example.demo.util.validator.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class CreateUserDto {
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @Email(message = "Email should be valid")
    @NotEmpty
    private String email;
    @ValidPassword(message = "Password should be valid")
    private String password;

    public CreateUserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
