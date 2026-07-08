package com.example.imageboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 * =========================================================================
 * TASK 2 TESTS: Like and unlike the image
 * =========================================================================
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class LikeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ===== PLACEHOLDER: BACKEND TEAM - WRITE TESTS HERE =====
    // TODO (Task 2 - tests): POST /api/images/{id}/like increments the
    // like count by 1 and returns the new count.
    @Test
    void like_incrementsLikeCount() {
        // TODO: implement
    }

    // TODO (Task 2 - tests): POST /api/images/{id}/unlike decrements the
    // like count by 1 and returns the new count.
    @Test
    void unlike_decrementsLikeCount() {
        // TODO: implement
    }

    // TODO (Task 2 - tests): like count never goes below 0.
    @Test
    void unlike_neverGoesBelowZero() {
        // TODO: implement
    }

    // TODO (Task 2 - tests): liking/unliking an unknown image id returns 404.
    @Test
    void likeUnknownImage_returnsNotFound() {
        // TODO: implement
    }
    // ==========================================================
}
