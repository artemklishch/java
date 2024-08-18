package com.example.docker.service.impl;

import com.example.docker.dto.CreatePostRequestDto;
import com.example.docker.dto.PostResponseDto;
import com.example.docker.mapper.PostMapper;
import com.example.docker.repository.PostRepository;
import com.example.docker.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public PostResponseDto save(CreatePostRequestDto requestDto) {
        return postMapper.toDto(postRepository.save(postMapper.toEntity(requestDto)));
    }

    @Override
    public List<PostResponseDto> getAll(Pageable pageable) {
        return postRepository.findAll(pageable).stream()
                .map(postMapper::toDto)
                .toList();
    }
}
