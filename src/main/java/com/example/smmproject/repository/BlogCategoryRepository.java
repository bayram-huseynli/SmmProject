package com.example.smmproject.repository;

import com.example.smmproject.entity.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCategoryRepository extends JpaRepository<BlogCategory,Long> {

    boolean existsBlogType(String blogType);
}
