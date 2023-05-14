package com.geekster.IntagramProject.services;

import com.geekster.IntagramProject.repositories.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    IPostRepo iPostRepo;
}
