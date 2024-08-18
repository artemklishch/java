package com.example.docker.controller;

import com.example.docker.dto.CreatePostRequestDto;
import com.example.docker.dto.PostResponseDto;
import com.example.docker.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    public PostResponseDto save(@RequestBody CreatePostRequestDto requestDto) {
        return postService.save(requestDto);
    }

    @GetMapping
    public List<PostResponseDto> findAll(Pageable pageable) {
        return postService.getAll(pageable);
    }
}
