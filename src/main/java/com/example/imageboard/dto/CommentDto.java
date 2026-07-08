package com.example.imageboard.dto;

import java.time.Instant;

/**
 * Infra-only -- NOT a task placeholder.
 */
public record CommentDto(
        Long id,
        String text,
        Instant createdAt
) {
}
