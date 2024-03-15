package com.example.smmproject.service;

import java.util.Map;
import java.util.Optional;

public interface TariffService {
    Optional<Integer> calculatePriceForService(String serviceType, Integer quantity);
    Integer calculateTotalPrice(Map<String, Integer> selectedServices);
}
