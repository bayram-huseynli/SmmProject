package com.example.smmproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String managerType;

    private String context;
    @OneToOne(mappedBy = "manager")
    private Portfolio portfolio;

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String managerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public String context() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Portfolio portfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
