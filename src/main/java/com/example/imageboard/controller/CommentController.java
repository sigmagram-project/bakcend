package com.example.imageboard.controller;

import com.example.imageboard.dto.CommentDto;
import com.example.imageboard.dto.CommentRequest;
import com.example.imageboard.repository.CommentRepository;
import com.example.imageboard.repository.ImageRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =========================================================================
 * TASK 3: Comment on the image
 * =========================================================================
 */
@RestController
@RequestMapping("/api/images/{id}/comments")
public class CommentController {

    private final CommentRepository commentRepository;
    private final ImageRepository imageRepository;

    public CommentController(CommentRepository commentRepository, ImageRepository imageRepository) {
        this.commentRepository = commentRepository;
        this.imageRepository = imageRepository;
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM =====
    // TODO (Task 3 - backend):
    //   Look up the image by id, create a CommentEntity from the
    //   request body, save it via commentRepository, and return it
    //   as a CommentDto with 201 Created.
    // ======================================
    @PostMapping
    public ResponseEntity<CommentDto> addComment(@PathVariable Long id, @Valid @RequestBody CommentRequest request) {
        throw new UnsupportedOperationException("TODO: implement adding a comment (Task 3 - backend)");
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM =====
    // TODO (Task 3 - backend):
    //   Return all comments for the given image, oldest first, as a
    //   list of CommentDto.
    // ======================================
    @GetMapping
    public ResponseEntity<List<CommentDto>> listComments(@PathVariable Long id) {
        throw new UnsupportedOperationException("TODO: implement listing comments (Task 3 - backend)");
    }
}
