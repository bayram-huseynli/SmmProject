package com.example.smmproject.repository;

import com.example.smmproject.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
}
