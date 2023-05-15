package com.geekster.IntagramProject.services;

import com.geekster.IntagramProject.models.Post;
import com.geekster.IntagramProject.repositories.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    IPostRepo iPostRepo;

    public Post savePost(Post post){
        return iPostRepo.save(post);
    }
    public List<Post> getAllPosts(){
        return iPostRepo.findAll();
    }
}
