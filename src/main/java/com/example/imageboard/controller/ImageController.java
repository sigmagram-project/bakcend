package com.example.imageboard.controller;

import com.example.imageboard.dto.ImageSummaryDto;
import com.example.imageboard.repository.ImageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM =====
    // TODO (Task 1 - backend):
    //   1. Accept a multipart file upload ("file" part).
    //   2. Validate content type (image/*) and size.
    //   3. Build an ImageEntity from the upload and persist it via
    //      imageRepository.save(...).
    //   4. Return 201 Created with an ImageSummaryDto for the saved image.
    // ======================================
    @PostMapping
    public ResponseEntity<ImageSummaryDto> uploadImage(@RequestParam("file") MultipartFile file) {
        throw new UnsupportedOperationException("TODO: implement image upload (Task 1 - backend)");
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM =====
    // TODO (Task 1 - backend):
    //   Return all images (as ImageSummaryDto, newest first) so the
    //   frontend gallery can render them.
    // ======================================
    @GetMapping
    public ResponseEntity<List<ImageSummaryDto>> listImages() {
        throw new UnsupportedOperationException("TODO: implement image listing (Task 1 - backend)");
    }

    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM =====
    // TODO (Task 1 - backend):
    //   Look up the image by id and stream back its raw bytes with the
    //   correct Content-Type header, so the frontend can use this URL
    //   directly as an <img src="..."> value.
    // ======================================
    @GetMapping("/{id}/data")
    public ResponseEntity<byte[]> getImageData(@PathVariable Long id) {
        throw new UnsupportedOperationException("TODO: implement image byte serving (Task 1 - backend)");
    }
}
