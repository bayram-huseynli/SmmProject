package com.example.smmproject.dto.Request;


import java.time.LocalDate;

public class PortfolioRequest {
    private Long portfolioCategoryId;
    private String name;
    private Long managerType;
    private String customerName;
    private LocalDate date;
    private String shortDescription;
    private String doneWorks;

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

    public String doneWorks() {
        return doneWorks;
    }

    public void setDoneWorks(String doneWorks) {
        this.doneWorks = doneWorks;
    }

    public Long managerType() {
        return managerType;
    }

    public void setManagerType(Long managerType) {
        this.managerType = managerType;
    }
}
