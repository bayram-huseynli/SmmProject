package com.example.smmproject.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @Column(length = 1000)
    private String shortDescription;
    @ElementCollection
    private List<String> goals = new ArrayList<>();
    @ElementCollection
    private List<String> services = new ArrayList<>();
    @ElementCollection
    @Column(name = "photo_links",length = 100000)
    private List<String> photos = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "portfolio_category_id")
    private PortfolioCategory portfolioCategory;
    @OneToOne
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

    public String shortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<String> goals() {
        return goals;
    }

    public void setGoals(List<String> goals) {
        this.goals = goals;
    }

    public List<String> services() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public List<String> photos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
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

