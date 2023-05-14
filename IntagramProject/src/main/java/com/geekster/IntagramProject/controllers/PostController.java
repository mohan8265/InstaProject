package com.geekster.IntagramProject.controllers;

import com.geekster.IntagramProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    PostService postService;
}
