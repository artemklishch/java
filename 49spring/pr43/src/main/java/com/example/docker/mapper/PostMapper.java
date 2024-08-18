package com.example.docker.mapper;

import com.example.docker.config.MapperConfig;
import com.example.docker.dto.CreatePostRequestDto;
import com.example.docker.dto.PostResponseDto;
import com.example.docker.model.Post;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface PostMapper {
    Post toEntity(CreatePostRequestDto requestDto);

    PostResponseDto toDto(Post post);
}
