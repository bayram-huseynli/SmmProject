package com.example.smmproject.dto.Response;

import java.time.LocalDate;


public class PortfolioResponse {
    private Long id;
    private Long portfolioCategoryId;
    private String name;
    private Long managerTypeId;
    private String customerName;
    private String description;
    private LocalDate date;
;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getManagerTypeId() {
        return managerTypeId;
    }

    public void setManagerTypeId(Long managerTypeId) {
        this.managerTypeId = managerTypeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
