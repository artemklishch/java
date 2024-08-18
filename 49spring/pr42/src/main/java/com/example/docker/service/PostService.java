package com.example.docker.service;

import com.example.docker.dto.CreatePostRequestDto;
import com.example.docker.dto.PostResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    PostResponseDto save(CreatePostRequestDto requestDto);

    List<PostResponseDto> getAll(Pageable pageable);
}
