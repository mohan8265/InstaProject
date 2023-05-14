package com.geekster.IntagramProject.services;

import com.geekster.IntagramProject.models.AuthenticationToken;
import com.geekster.IntagramProject.repositories.IAuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationTokenRepo iAuthenticationTokenRepo;

    public void saveToken(AuthenticationToken authenticationToken){
        iAuthenticationTokenRepo.save(authenticationToken);
    }
}
