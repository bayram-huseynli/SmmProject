package com.example.smmproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "portfolio_category")
public class PortfolioCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String portfolioType;
    @OneToMany(mappedBy = "portfolioCategory")
    private List<Portfolio> portfolios;


    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String portfolioType() {
        return portfolioType;
    }

    public void setPortfolioType(String portfolioType) {
        this.portfolioType = portfolioType;
    }

    public List<Portfolio> portfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }
}
