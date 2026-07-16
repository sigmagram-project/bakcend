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

    @PostMapping
    public ResponseEntity<CommentDto> addComment(
            @PathVariable Long id,
            @Valid @RequestBody CommentRequest request
    ) {
        ImageEntity image = findImage(id);

        CommentEntity comment = new CommentEntity();
        comment.setImage(image);
        comment.setText(request.text());

        CommentEntity savedComment = commentRepository.save(comment);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toDto(savedComment));
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> listComments(
            @PathVariable Long id
    ) {
        findImage(id);

        List<CommentDto> comments = commentRepository
                .findByImageIdOrderByCreatedAtAsc(id)
                .stream()
                .map(CommentController::toDto)
                .toList();

        return ResponseEntity.ok(comments);
    }

    private ImageEntity findImage(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Image not found"
                ));
    }

    private static CommentDto toDto(CommentEntity comment) {
        return new CommentDto(
                comment.getId(),
                comment.getText(),
                comment.getCreatedAt()
        );
    }
}