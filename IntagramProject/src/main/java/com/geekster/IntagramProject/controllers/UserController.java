package com.geekster.IntagramProject.controllers;

import com.geekster.IntagramProject.dto.SignInInput;
import com.geekster.IntagramProject.dto.SignInOutput;
import com.geekster.IntagramProject.dto.SignUpInput;
import com.geekster.IntagramProject.dto.SignUpOutput;
import com.geekster.IntagramProject.services.AuthenticationService;
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

    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/signUp")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpInput){
        return userService.signUp(signUpInput);
    }
    @PostMapping("/signIn")
    public SignInOutput signIn(@RequestBody SignInInput signInInput){
        return userService.signIn(signInInput);
    }
}
