package com.example.imageboard.dto;

import java.time.Instant;

/**
 * Infra-only -- NOT a task placeholder.
 * Shape returned to the frontend for the image gallery. Deliberately excludes
 * the raw byte[] -- images are served separately via GET /api/images/{id}/data.
 */
public record ImageSummaryDto(
        Long id,
        String filename,
        int likeCount,
        Instant uploadedAt
) {
}
