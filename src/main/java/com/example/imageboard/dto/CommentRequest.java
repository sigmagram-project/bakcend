package com.example.imageboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Infra-only -- NOT a task placeholder.
public record CommentRequest(
        @NotBlank @Size(max = 1000) String text
) {
}
