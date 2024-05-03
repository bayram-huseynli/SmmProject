package com.example.smmproject.repository;

import com.example.smmproject.entity.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory,Long> {

    boolean existsByBlogType(String blogType);
}
