package com.example.englishhero.English.Hero.controller;

import com.example.englishhero.English.Hero.entities.User;
import com.example.englishhero.English.Hero.requests.UserRequest;
import com.example.englishhero.English.Hero.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    List<UserRequest> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable Long userId) {
        return userService.getUsersById(userId);
    }

    @PostMapping
    UserRequest postUser(@RequestBody User user) {
        return userService.postUsers(user);
    }
}
