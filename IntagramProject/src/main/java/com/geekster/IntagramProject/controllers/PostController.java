package com.geekster.IntagramProject.controllers;

import com.geekster.IntagramProject.models.Post;
import com.geekster.IntagramProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping()
    public Post savePost(@RequestBody Post post){
        return postService.savePost(post);
    }

    @GetMapping()
    public List<Post> getPosts(){
        return postService.getAllPosts();
    }
}
