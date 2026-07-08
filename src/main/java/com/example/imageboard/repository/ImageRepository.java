package com.example.imageboard.repository;

import com.example.imageboard.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Infra-only -- NOT a task placeholder.
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
