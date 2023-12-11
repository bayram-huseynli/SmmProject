package com.example.smmproject.service;

import com.example.smmproject.dto.Request.WantedPacketRequest;

public interface WantedPacketService {
    Long calculatePrice(WantedPacketRequest wantedPacketRequest);

}
