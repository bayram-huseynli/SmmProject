package com.example.smmproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String managerType;
    @Lob
    private String context;
    @OneToMany(mappedBy = "manager")
    private List<Portfolio> portfolios;

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

    public List<Portfolio> portfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }
}
