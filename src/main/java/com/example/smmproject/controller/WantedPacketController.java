package com.example.smmproject.controller;

import com.example.smmproject.dto.request.WantedPacketRequest;
import com.example.smmproject.service.WantedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wanted-packet")
public class WantedPacketController {

    private final WantedPacketService wantedPacketService;

    @Autowired
    public WantedPacketController(WantedPacketService wantedPacketService) {
        this.wantedPacketService = wantedPacketService;
    }

    @PostMapping("/calculate-price")
    public Long calculatePrice(@RequestBody WantedPacketRequest wantedPacket) {
        return wantedPacketService.calculatePrice(wantedPacket);
    }
}
