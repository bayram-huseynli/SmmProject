package com.example.smmproject.repository;

import com.example.smmproject.entity.PortfolioCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioCategoryRepository extends JpaRepository<PortfolioCategory, Long> {
    boolean existsByPortfolioType(String portfolioType);
}
