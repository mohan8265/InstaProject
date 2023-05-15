package com.geekster.IntagramProject.services;

import com.geekster.IntagramProject.models.AuthenticationToken;
import com.geekster.IntagramProject.models.User;
import com.geekster.IntagramProject.repositories.IAuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationTokenRepo iAuthenticationTokenRepo;

    public void saveToken(AuthenticationToken token){
        iAuthenticationTokenRepo.save(token);
    }

    public AuthenticationToken getToken(User user){
        return iAuthenticationTokenRepo.findByUser(user);
    }

    public boolean authenticate(String email, String token){
        AuthenticationToken authenticationToken = iAuthenticationTokenRepo.findFirstByToken(token);
        Optional<String> expectEmail = Optional.ofNullable(authenticationToken.getUser().getEmail());
        if(expectEmail.isPresent()){
            return true;
        }else{
            return false;
        }
    }
}
