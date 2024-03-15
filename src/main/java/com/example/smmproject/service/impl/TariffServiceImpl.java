package com.example.smmproject.service.impl;

import com.example.smmproject.entity.Tariff;
import com.example.smmproject.repository.TariffRepository;
import com.example.smmproject.service.TariffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service

public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepository;

    public TariffServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }
    @Override
    public Optional<Integer> calculatePriceForService(String serviceType, Integer quantity) {
        List<Tariff> tariffs = tariffRepository.findByServiceType(serviceType);
        return tariffs.stream()
                .filter(tariff -> quantity >= tariff.getDurationStart() && quantity <= tariff.getDurationEnd())
                .findFirst()
                .map(Tariff::getPrice);
    }
    @Override
    public Integer calculateTotalPrice(Map<String, Integer> selectedServices) {
        return selectedServices.entrySet().stream()
                .map(entry -> calculatePriceForService(entry.getKey(), entry.getValue()).orElse(0))
                .reduce(0, Integer::sum);
    }
}
