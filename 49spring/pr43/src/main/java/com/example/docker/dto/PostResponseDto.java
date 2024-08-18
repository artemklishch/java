package com.example.docker.dto;

public record PostResponseDto(
        Long id,
        String title,
        String body
) {
}
