package com.geekster.IntagramProject.services;

import com.geekster.IntagramProject.dto.SignInInput;
import com.geekster.IntagramProject.dto.SignInOutput;
import com.geekster.IntagramProject.dto.SignUpInput;
import com.geekster.IntagramProject.dto.SignUpOutput;
import com.geekster.IntagramProject.models.AuthenticationToken;
import com.geekster.IntagramProject.models.User;
import com.geekster.IntagramProject.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.security.NoSuchAlgorithmException;


@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    AuthenticationService authenticationService;

    public SignUpOutput signUp(SignUpInput signUpInput){
        User userCheck = iUserRepo.findFirstByEmail(signUpInput.getEmail());

        if(userCheck != null){
            throw new IllegalStateException("User already exits...");
        }

//        for encryption
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpInput.getPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        User user = new User(signUpInput.getFirstName(),signUpInput.getLastName(),signUpInput.getAge(),
                signUpInput.getPhoneNumber(),signUpInput.getEmail(),encryptedPassword);

        iUserRepo.save(user);

        AuthenticationToken token = new AuthenticationToken(user);
        authenticationService.saveToken(token);

        return new SignUpOutput(HttpStatus.OK, "User sign up successfully...");
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException{
        String encryptedPassword = "##" + password +"##";
        return encryptedPassword;
    }

    public SignInOutput signIn(SignInInput signInInput){
        User userCheck = iUserRepo.findFirstByEmail(signInInput.getEmail());
        if(userCheck == null){
            throw new IllegalStateException("invalid details try again!!!");
        }

        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signInInput.getPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        boolean passwordCheck = encryptedPassword.equals(userCheck.getPassword());
        if(passwordCheck){
            throw new IllegalStateException("Invalid User....");
        }

        AuthenticationToken token = authenticationService.getToken(userCheck);
        return new SignInOutput(HttpStatus.OK,token.getToken());
    }

    public void updateUser(SignUpInput signUpInput){
        User userCheck = iUserRepo.findFirstByEmail(signUpInput.getEmail());
        if(userCheck == null){
            throw new IllegalStateException("Invalid user...");
        }
        String encryptedPassword = null;
        if(signUpInput.getEmail() != null){
            try {
                encryptedPassword = encryptPassword(signUpInput.getPassword());
            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
        }

        User user = new User(userCheck.getUserId(),signUpInput.getFirstName(),signUpInput.getLastName(),
                signUpInput.getAge(),signUpInput.getPhoneNumber(),signUpInput.getEmail(),encryptedPassword);

        iUserRepo.save(user);

    }
}
