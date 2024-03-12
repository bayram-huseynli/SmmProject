package com.example.smmproject.service;

import com.example.smmproject.dto.request.WantedPacketRequest;

public interface WantedPacketService {
    Long calculatePrice(WantedPacketRequest wantedPacketRequest);

}
