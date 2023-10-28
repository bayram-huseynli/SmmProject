package com.example.smmproject.dto.Response;

public class PortfolioCategoryResponse {
    private Long id;
    private String portfolioType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPortfolioType() {
        return portfolioType;
    }

    public void setPortfolioType(String portfolioType) {
        this.portfolioType = portfolioType;
    }
}
