package com.example.imageboard.controller;

import com.example.imageboard.entity.ImageEntity;
import com.example.imageboard.repository.ImageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/api/images/{id}")
public class LikeController {

    private final ImageRepository imageRepository;

    public LikeController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM (Task 2) =====
    // POST /api/images/{id}/like
    @PostMapping("/like")
    public ResponseEntity<Integer> like(@PathVariable Long id) {
        // Hint: throw ResponseStatusException with BAD_REQUEST when invalid.

        if(Objects.nonNull(id) && id > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be not null and greater than 0");
        }

        // The helper finds the image or returns HTTP 404.
        ImageEntity image = findImage(id);

        // Read the current value from the image.
        int currentLikeCount = image.getLikeCount();

        int updatedLikeCount = currentLikeCount + 1;

        // Store the new value on the entity.
        image.setLikeCount(updatedLikeCount);

        // Save the changed image in the database.
        ImageEntity savedImage = imageRepository.save(image);

        // Return the updated number to the frontend.
        return ResponseEntity.ok(savedImage.getLikeCount());
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM (Task 2) =====
    // POST /api/images/{id}/unlike
    @PostMapping("/unlike")
    public ResponseEntity<Integer> unlike(@PathVariable Long id) {
        if(Objects.nonNull(id) && id > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be not null and greater than 0");
        }

        ImageEntity image = findImage(id);
        int currentLikeCount = image.getLikeCount();

        // Hint: use an if statement or Math.max(...).

        int updatedLikeCount = 0;
        if(currentLikeCount > 0) {
            updatedLikeCount = currentLikeCount - 1;
        }

        image.setLikeCount(updatedLikeCount);
        ImageEntity savedImage = imageRepository.save(image);

        return ResponseEntity.ok(savedImage.getLikeCount());
    }

    // Shared helper used by both endpoints.
    private ImageEntity findImage(Long id) {
        // findById returns an Optional because the image may not exist.
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Can't find ID"
                ));
    }
}
