package com.example.imageboard.controller;

import com.example.imageboard.repository.ImageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * =========================================================================
 * TASK 2: Like and unlike the image
 * =========================================================================
 * Note: there is no user login for this app, so "like" is a simple counter
 * on the image (not tied to a specific user). The frontend is responsible
 * for tracking whether the current visitor has already liked an image
 * (see the Task 2 frontend placeholder in LikeButton.jsx).
 */
@RestController
@RequestMapping("/api/images/{id}")
public class LikeController {

    private final ImageRepository imageRepository;

    public LikeController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM =====
    // TODO (Task 2 - backend):
    //   Look up the image, increment likeCount by 1, save, and return
    //   the new like count.
    // ======================================
    @PostMapping("/like")
    public ResponseEntity<Integer> like(@PathVariable Long id) {
        throw new UnsupportedOperationException("TODO: implement like (Task 2 - backend)");
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM =====
    // TODO (Task 2 - backend):
    //   Look up the image, decrement likeCount by 1 (never below 0),
    //   save, and return the new like count.
    // ======================================
    @PostMapping("/unlike")
    public ResponseEntity<Integer> unlike(@PathVariable Long id) {
        throw new UnsupportedOperationException("TODO: implement unlike (Task 2 - backend)");
    }
}
