package com.example.imageboard.controller;

import com.example.imageboard.dto.ImageSummaryDto;
import com.example.imageboard.entity.ImageEntity;
import com.example.imageboard.repository.ImageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * =========================================================================
 * TASK 1: Upload an image and display it in the frontend
 * =========================================================================
 */
@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageRepository imageRepository;

    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @PostMapping
    public ResponseEntity<ImageSummaryDto> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File is required");
        }
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only image uploads are allowed");
        }

        ImageEntity image = new ImageEntity();
        image.setFilename(file.getOriginalFilename() != null ? file.getOriginalFilename() : "unnamed");
        image.setContentType(contentType);
        try {
            image.setData(file.getBytes());
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not read uploaded file", e);
        }

        ImageEntity saved = imageRepository.save(image);
        return ResponseEntity.status(HttpStatus.CREATED).body(toSummary(saved));
    }

    @GetMapping
    public ResponseEntity<List<ImageSummaryDto>> listImages() {
        List<ImageSummaryDto> images = imageRepository.findAll().stream()
                .sorted(Comparator.comparing(ImageEntity::getUploadedAt).reversed())
                .map(ImageController::toSummary)
                .toList();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{id}/data")
    public ResponseEntity<byte[]> getImageData(@PathVariable Long id) {
        ImageEntity image = imageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found"));

        MediaType mediaType;
        try {
            mediaType = MediaType.parseMediaType(image.getContentType());
        } catch (Exception e) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }
        return ResponseEntity.ok().contentType(mediaType).body(image.getData());
    }

    private static ImageSummaryDto toSummary(ImageEntity image) {
        return new ImageSummaryDto(image.getId(), image.getFilename(), image.getLikeCount(), image.getUploadedAt());
    }
}
