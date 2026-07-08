package com.example.imageboard.controller;

import com.example.imageboard.dto.FeedbackRequest;
import com.example.imageboard.repository.FeedbackRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * =========================================================================
 * TASK 4: Closing the page and asking for feedback
 * =========================================================================
 */
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;

    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM =====
    // TODO (Task 4 - backend):
    //   Persist the feedback message via feedbackRepository.save(...)
    //   and return 201 Created. Keep this endpoint fast/non-blocking --
    //   it may be called from a beforeunload/visibilitychange handler
    //   on the frontend, which gives very little time to complete.
    // ======================================
    @PostMapping
    public ResponseEntity<Void> submitFeedback(@Valid @RequestBody FeedbackRequest request) {
        throw new UnsupportedOperationException("TODO: implement feedback submission (Task 4 - backend)");
    }
}
