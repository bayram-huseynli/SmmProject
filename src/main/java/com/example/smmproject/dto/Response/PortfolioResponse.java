package com.example.smmproject.dto.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PortfolioResponse {
    private Long id;
    private Long portfolioCategoryId;
    private String name;
    private Long managerTypeId;
    private String customerName;
    private LocalDate date;
    private String shortDescription;
    private List<String> goals = new ArrayList<>();
    private List<String> services = new ArrayList<>();
    private List<String> photos = new ArrayList<>();

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

    public Long managerTypeId() {
        return managerTypeId;
    }

    public void setManagerTypeId(Long managerTypeId) {
        this.managerTypeId = managerTypeId;
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
}
