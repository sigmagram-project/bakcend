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
import java.time.LocalDate;
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
    public ResponseEntity<ImageSummaryDto> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File is required");
        }
        String contentType = file.getContentType();
        if (!contentType.startsWith("image/")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only image uploads are allowed");
        }
        if(file.getOriginalFilename() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error");
        }
        ImageEntity image = new ImageEntity();

        image.setFilename(file.getOriginalFilename() + "_" + LocalDate.now());
        image.setData(file.getBytes());
        image.setContentType(contentType);

        ImageEntity saved = imageRepository.save(image);
        return ResponseEntity.status(HttpStatus.CREATED).body(toSummary(saved));
    }



    // ---------------------------------------------------------------
    // ===== PLACEHOLDER: BACKEND TEAM =====
    // TODO (Task 1 - backend):
    //   Return all images (as ImageSummaryDto, newest first) so the
    //   frontend gallery can render them.
    //
    //   Hints:
    //   1. imageRepository.findAll() gives you a List<ImageEntity>.
    //   2. Sort it by uploadedAt, newest first -- e.g.
    //      Comparator.comparing(ImageEntity::getUploadedAt).reversed()
    //   3. Convert each ImageEntity into an ImageSummaryDto using the
    //      toSummary(...) helper already defined at the bottom of this class.
    //   4. One way to do all 3 steps at once:
    //      imageRepository.findAll().stream()
    //          .sorted(Comparator.comparing(ImageEntity::getUploadedAt).reversed())
    //          .map(ImageController::toSummary)
    //          .toList();
    // ======================================
    @GetMapping
    public ResponseEntity<List<ImageSummaryDto>> listImages() {
        List<ImageSummaryDto> images = null; //write logic to get images from  imageRepository.findAll() and map it ImageSummaryDto using toSummary;
        return ResponseEntity.ok(images);
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
        ImageEntity image = null; //write code to get the ImageEntity from imageRepository

        MediaType mediaType;
        try {
            mediaType = MediaType.parseMediaType(image.getContentType());
        } catch (Exception e) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }
        return ResponseEntity.ok().contentType(mediaType).body(null); // TODO: return image.getData() instead of null
    }

    private static ImageSummaryDto toSummary(ImageEntity image) {
        return new ImageSummaryDto(image.getId(), image.getFilename(), image.getLikeCount(), image.getUploadedAt());
    }
}
