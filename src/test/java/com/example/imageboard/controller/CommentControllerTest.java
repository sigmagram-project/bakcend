package com.example.imageboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 * =========================================================================
 * TASK TESTS: Comment on the image
 * =========================================================================
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ===== PLACEHOLDER: BACKEND TEAM - WRITE TESTS HERE =====
    // TODO (Task - tests): POST /api/images/{id}/comments with a valid
    // body creates a comment and returns 201 with the comment payload.
    @Test
    void addComment_withValidText_returnsCreated() {
        // TODO: implement
    }

    // TODO (Task - tests): POST with a blank/too-long comment returns 400.
    @Test
    void addComment_withInvalidText_returnsBadRequest() {
        // TODO: implement
    }

    // TODO (Task - tests): GET /api/images/{id}/comments returns
    // comments in chronological order.
    @Test
    void listComments_returnsCommentsInOrder() {
        // TODO: implement
    }
    // ==========================================================
}
