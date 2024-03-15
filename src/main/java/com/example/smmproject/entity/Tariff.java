package com.example.smmproject.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serviceType;

    @Column(nullable = false)
    private Integer durationStart;

    @Column(nullable = false)
    private Integer durationEnd;

    @Column(nullable = false)
    private Integer price;

}

