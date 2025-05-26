package com.HelloEvents.HelloEvents.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Email;

public class UserDto {

    @Getter
    @Setter
    @NotNull
    @Email(message = "Email should be valid")
    private String email; // Using camelCase for field name

    @Getter
    @Setter
    @NotNull
    private String password;
    private String role;
    private String matchingPassword;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Constructor
    public UserDto(String email, String password, String matchingPassword) {
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    // Optionally, you can add a method to check if the passwords match
    public boolean passwordsMatch() {
        return this.password != null && this.password.equals(this.matchingPassword);
    }
}
