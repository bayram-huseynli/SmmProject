package com.example.smmproject.repository;

import com.example.smmproject.entity.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TariffRepository extends JpaRepository<Tariff,Long> {
    List<Tariff> findByServiceType(String serviceType);
}
