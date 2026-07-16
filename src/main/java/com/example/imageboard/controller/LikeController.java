package com.example.imageboard.controller;

import com.example.imageboard.entity.ImageEntity;
import com.example.imageboard.repository.ImageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/images/{id}")
public class LikeController {

    private final ImageRepository imageRepository;

    public LikeController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @PostMapping("/like")
    public ResponseEntity<Integer> like(@PathVariable Long id) {
        validateId(id);

        ImageEntity image = findImage(id);

        int updatedLikeCount = image.getLikeCount() + 1;
        image.setLikeCount(updatedLikeCount);

        ImageEntity savedImage = imageRepository.save(image);

        return ResponseEntity.ok(savedImage.getLikeCount());
    }

    @PostMapping("/unlike")
    public ResponseEntity<Integer> unlike(@PathVariable Long id) {
        validateId(id);

        ImageEntity image = findImage(id);

        int updatedLikeCount = Math.max(0, image.getLikeCount() - 1);
        image.setLikeCount(updatedLikeCount);

        ImageEntity savedImage = imageRepository.save(image);

        return ResponseEntity.ok(savedImage.getLikeCount());
    }

    private void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Image id must be greater than 0"
            );
        }
    }

    private ImageEntity findImage(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Image not found"
                ));
    }
}