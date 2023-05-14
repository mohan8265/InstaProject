package com.geekster.IntagramProject.services;

import com.geekster.IntagramProject.models.AuthenticationToken;
import com.geekster.IntagramProject.models.User;
import com.geekster.IntagramProject.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    AuthenticationService authenticationService;

    public void signUp(User user) {
        User userCheck = iUserRepo.findFirstByEmail(user.getEmail());
        if(userCheck != null){
            throw new IllegalStateException("User already exits...");
        }else {
            iUserRepo.save(user);

            AuthenticationToken token =new AuthenticationToken(user);

            authenticationService.saveToken(token);
        }
    }

    public
}
