package com.geekster.IntagramProject.controllers;

import com.geekster.IntagramProject.models.User;
import com.geekster.IntagramProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping()
    public void signUp(@RequestBody User user){
        userService.signUp(user);
    }

    public
}
