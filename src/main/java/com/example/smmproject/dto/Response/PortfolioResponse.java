package com.example.smmproject.dto.Response;

import java.time.LocalDate;

public class PortfolioResponse {
    private Long id;
    private Long portfolioCategoryId;
    private String name;
    private Long managerTypeId;
    private String customerName;
    private LocalDate date;
    private String shortDescription;
    private String doneWorks;

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long managerTypeId() {
        return managerTypeId;
    }

    public void setManagerTypeId(Long managerTypeId) {
        this.managerTypeId = managerTypeId;
    }
}