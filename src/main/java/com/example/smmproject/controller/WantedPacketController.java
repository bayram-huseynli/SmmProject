package com.example.smmproject.controller;

import com.example.smmproject.service.TariffService;
import com.example.smmproject.service.WantedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/wanted-packet")
public class WantedPacketController {

    private final TariffService tariffService;

    public WantedPacketController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("/calculate-single-price")
    public ResponseEntity<?> calculatePriceForSingleService(@RequestParam String serviceType, @RequestParam Integer quantity) {
        return tariffService.calculatePriceForService(serviceType, quantity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body(Integer.valueOf("Fiyat aralığı bulunamadı veya hatalı miktar girişi.")));
    }
    @PostMapping("/calculate-price")
    public ResponseEntity<Integer> calculateTotalPrice(@RequestBody Map<String, Integer> selectedServices) {
        Integer totalPrice = tariffService.calculateTotalPrice(selectedServices);
        return ResponseEntity.ok(totalPrice);
    }
}
