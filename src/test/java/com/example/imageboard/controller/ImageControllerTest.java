package com.example.imageboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 * =========================================================================
 * TASK 1 TESTS: Upload an image and display it in the frontend
 * =========================================================================
 * Uses the "test" profile -> H2 in-memory DB (see application-test.yml),
 * so these tests don't need Postgres/Docker running.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ImageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ===== PLACEHOLDER: BACKEND TEAM - WRITE TESTS HERE =====
    // TODO (Task 1 - tests): POST /api/images with a valid image file
    // returns 201 and a body containing the generated id.
    @Test
    void uploadImage_withValidFile_returnsCreated() {
        // TODO: implement
    }

    // TODO (Task 1 - tests): POST /api/images with a non-image file (or
    // no file) is rejected with 400.
    @Test
    void uploadImage_withInvalidFile_returnsBadRequest() {
        // TODO: implement
    }

    // TODO (Task 1 - tests): GET /api/images returns previously uploaded
    // images, newest first.
    @Test
    void listImages_returnsUploadedImages() {
        // TODO: implement
    }

    // TODO (Task 1 - tests): GET /api/images/{id}/data returns the raw
    // bytes with the correct Content-Type for an existing image, and 404
    // for an unknown id.
    @Test
    void getImageData_returnsBytesOrNotFound() {
        // TODO: implement
    }
    // ==========================================================
}
