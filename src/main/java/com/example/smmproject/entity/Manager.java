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

    public void setId(Long id) {

    }
}
