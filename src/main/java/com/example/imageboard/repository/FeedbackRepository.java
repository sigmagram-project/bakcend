package com.example.imageboard.repository;

import com.example.imageboard.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Infra-only -- NOT a task placeholder.
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {
}
