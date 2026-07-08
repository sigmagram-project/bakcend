package com.example.imageboard.repository;

import com.example.imageboard.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Infra-only -- NOT a task placeholder.
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByImageIdOrderByCreatedAtAsc(Long imageId);
}
