package com.example.imageboard.controller;

import com.example.imageboard.entity.ImageEntity;
import com.example.imageboard.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ImageController.class)
class ImageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImageRepository imageRepository;

    @Test
    void uploadImage_withValidFile_savesImageAndReturnsCreated() throws Exception {
        byte[] fileBytes = new byte[]{1, 2, 3};

        MockMultipartFile file = createMultipartFile(
                "photo.png",
                "image/png",
                fileBytes
        );

        ImageEntity savedImage = createImage(
                fileBytes
        );

        when(imageRepository.save(any(ImageEntity.class)))
                .thenReturn(savedImage);

        mockMvc.perform(multipart("/api/images").file(file))
                .andExpect(status().isCreated());

        verify(imageRepository).save(argThat(image ->
                "photo.png".equals(image.getFilename())
                        && "image/png".equals(image.getContentType())
                        && Arrays.equals(fileBytes, image.getData())
        ));
    }

    @Test
    void uploadImage_withInvalidFile_returnsBadRequest() throws Exception {
        MockMultipartFile file = createMultipartFile(
                "notes.txt",
                "text/plain",
                "not an image".getBytes()
        );

        verify(imageRepository, never()).save(any());

        mockMvc.perform(multipart("/api/images").file(file))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getImageData_withExistingImage_returnsBytes() throws Exception {
        byte[] imageBytes = new byte[]{10, 20, 30};

        ImageEntity image = createImage(
                imageBytes
        );

        when(imageRepository.findById(1L))
                .thenReturn(Optional.of(image));

        mockMvc.perform(get("/api/images/{id}/data", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType("image/png"))
                .andExpect(content().bytes(imageBytes));

        verify(imageRepository).findById(1L);
    }

    @Test
    void getImageData_withUnknownImage_returnsNotFound() throws Exception {
        when(imageRepository.findById(999L))
                .thenReturn(Optional.empty());

        mockMvc.perform(get("/api/images/{id}/data", 999L))
                .andExpect(status().isNotFound());

        verify(imageRepository).findById(999L);
    }

    private MockMultipartFile createMultipartFile(
            String filename,
            String contentType,
            byte[] data
    ) {
        return new MockMultipartFile(
                "file",
                filename,
                contentType,
                data
        );
    }

    private ImageEntity createImage(
            byte[] data
    ) {
        ImageEntity image = new ImageEntity();
        image.setFilename("photo.png");
        image.setContentType("image/png");
        image.setData(data);

        return image;
    }

}