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
    @Column(length = 1000)
    private String shortDescription;
    private String doneWorks;

    @OneToOne
    @JoinColumn(name = "portfolio_category_id")
    private PortfolioCategory portfolioCategory;
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Manager manager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDoneWorks() {
        return doneWorks;
    }

    public void setDoneWorks(String doneWorks) {
        this.doneWorks = doneWorks;
    }

    public PortfolioCategory getPortfolioCategory() {
        return portfolioCategory;
    }

    public void setPortfolioCategory(PortfolioCategory portfolioCategory) {
        this.portfolioCategory = portfolioCategory;
    }
}
