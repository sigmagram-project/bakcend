package com.example.imageboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Infra-only -- NOT a task placeholder.
public record FeedbackRequest(
        @NotBlank @Size(max = 2000) String message
) {
}
