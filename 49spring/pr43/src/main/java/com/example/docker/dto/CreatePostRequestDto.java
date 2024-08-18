package com.example.docker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequestDto {
    private String title;
    private String body;
}
