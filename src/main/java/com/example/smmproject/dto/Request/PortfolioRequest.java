package com.example.smmproject.dto.Request;


import java.time.LocalDate;
public class PortfolioRequest {
    private Long portfolioCategoryId;
    private String name;
    private Long managerType;
    private String customerName;
    private LocalDate date;
    private String description;

    public Long getPortfolioCategoryId() {
        return portfolioCategoryId;
    }

    public void setPortfolioCategoryId(Long portfolioCategoryId) {
        this.portfolioCategoryId = portfolioCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManagerType() {
        return managerType;
    }

    public void setManagerType(Long managerType) {
        this.managerType = managerType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

