package com.HelloEvents.HelloEvents.Controller;

import com.HelloEvents.HelloEvents.DTO.UserDto;
import com.HelloEvents.HelloEvents.Entity.User;
import com.HelloEvents.HelloEvents.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserDto request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserDto request) {
        return userService.login(request.getEmail(), request.getPassword());
    }
}
