package com.example.imageboard.dto;

import java.time.Instant;

public record ImageSummaryDto(
        Long id,
        String filename,
        int likeCount,
        Instant uploadedAt
) {
}
