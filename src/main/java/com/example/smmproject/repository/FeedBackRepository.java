package com.example.smmproject.repository;

import com.example.smmproject.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepository extends JpaRepository<Feedback,Long> {
}
