package com.example.smmproject.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String customerName;
    @DateTimeFormat()
    private LocalDate date;
    @Lob
    private String description;
    @ManyToOne
    @JoinColumn(name = "portfolio_category_id")
    private PortfolioCategory portfolioCategory;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String customerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate date() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PortfolioCategory portfolioCategory() {
        return portfolioCategory;
    }

    public void setPortfolioCategory(PortfolioCategory portfolioCategory) {
        this.portfolioCategory = portfolioCategory;
    }

    public Manager manager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}

