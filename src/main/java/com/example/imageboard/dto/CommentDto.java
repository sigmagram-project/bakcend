package com.example.imageboard.dto;

import java.time.Instant;

public record CommentDto(
        Long id,
        String text,
        Instant createdAt
) {
}
