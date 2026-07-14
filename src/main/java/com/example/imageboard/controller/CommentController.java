package com.example.imageboard.controller;

import com.example.imageboard.dto.CommentDto;
import com.example.imageboard.dto.CommentRequest;
import com.example.imageboard.entity.CommentEntity;
import com.example.imageboard.entity.ImageEntity;
import com.example.imageboard.repository.CommentRepository;
import com.example.imageboard.repository.ImageRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    public CommentController(
            CommentRepository commentRepository,
            ImageRepository imageRepository
    ) {
        this.commentRepository = commentRepository;
        this.imageRepository = imageRepository;
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM (Task 3) =====
    // POST /api/images/{id}/comments
    @PostMapping
    public ResponseEntity<CommentDto> addComment(
            @PathVariable Long id,
            @Valid @RequestBody CommentRequest request
    ) {
        // Find the image or return HTTP 404.
        ImageEntity image = findImage(id);

        // Create a new comment.
        CommentEntity comment = new CommentEntity();

        // TODO:
        // 1. Connect the comment to the image.
        // 2. Copy the text from request into the comment.
        //
        // Hints:
        // comment.setImage(...);
        // comment.setText(request.text());

        // Save the comment in the database.
        CommentEntity savedComment = commentRepository.save(comment);

        // Convert the saved entity into a DTO.
        CommentDto response = toDto(savedComment);

        // Return HTTP 201 Created.
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM (Task 3) =====
    // GET /api/images/{id}/comments
    @GetMapping
    public ResponseEntity<List<CommentDto>> listComments(
            @PathVariable Long id
    ) {
        // Make sure the image exists.
        findImage(id);

        // TODO:
        // 1. Get the comments using:
        //    commentRepository.findByImageIdOrderByCreatedAtAsc(id)
        // 2. Create a stream.
        // 3. Convert every CommentEntity into CommentDto using toDto(...).
        // 4. Collect the result into a list.
        //
        // Hint:
        // List<CommentDto> comments = commentRepository
        //         .findByImageIdOrderByCreatedAtAsc(id)
        //         .stream()
        //         .map(...)
        //         .toList();

        List<CommentDto> comments = List.of();

        return ResponseEntity.ok(comments);
    }

    // Finds the image or returns HTTP 404.
    private ImageEntity findImage(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Image not found"
                ));
    }

    // Converts a database entity into the object returned by the API.
    private static CommentDto toDto(CommentEntity comment) {
        return new CommentDto(
                comment.getId(),
                comment.getText(),
                comment.getCreatedAt()
        );
    }
}