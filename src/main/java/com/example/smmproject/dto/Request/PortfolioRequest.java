package com.example.smmproject.dto.Request;


import java.time.LocalDate;
public class PortfolioRequest {
    private Long portfolioCategoryId;
    private String name;
    private Long managerType;
    private String customerName;
    private LocalDate date;
    private String description;

    public Long portfolioCategoryId() {
        return portfolioCategoryId;
    }

    public void setPortfolioCategoryId(Long portfolioCategoryId) {
        this.portfolioCategoryId = portfolioCategoryId;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long managerType() {
        return managerType;
    }

    public void setManagerType(Long managerType) {
        this.managerType = managerType;
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
}
