package com.example.imageboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 * =========================================================================
 * TASK 4 TESTS: Closing the page and asking for feedback
 * =========================================================================
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FeedbackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ===== PLACEHOLDER: BACKEND TEAM - WRITE TESTS HERE =====
    // TODO (Task 4 - tests): POST /api/feedback with a valid message
    // returns 201 and the feedback is persisted.
    @Test
    void submitFeedback_withValidMessage_returnsCreated() {
        // TODO: implement
    }

    // TODO (Task 4 - tests): POST /api/feedback with a blank message
    // returns 400.
    @Test
    void submitFeedback_withBlankMessage_returnsBadRequest() {
        // TODO: implement
    }
    // ==========================================================
}
