package com.sparta.spartapersonaltask.controller;

import com.sparta.spartapersonaltask.dto.RequestPostDto;
import com.sparta.spartapersonaltask.dto.ResponsePostDto;
import com.sparta.spartapersonaltask.entity.Post;
import com.sparta.spartapersonaltask.service.PostService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }
    @PostMapping("/posts")
    public ResponsePostDto savePost(@RequestBody RequestPostDto requestPostDto){
        return postService.save(requestPostDto);
    }

    @GetMapping("/posts")
    public List<ResponsePostDto> findAllPost(){
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public ResponsePostDto viewPost(@PathVariable Long id){
        return postService.findById(id);
    }

    @PatchMapping("/posts/{id}")
    public ResponsePostDto editPost(@PathVariable Long id, @RequestBody @Valid RequestPostDto requestPostDto){
        return postService.editPost(id, requestPostDto);
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id, @RequestBody RequestPostDto requestPostDto){
        return postService.deletePost(id, requestPostDto.getPassword());
    }
}
