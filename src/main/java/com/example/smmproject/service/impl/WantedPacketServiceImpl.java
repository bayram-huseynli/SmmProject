package com.example.smmproject.service.impl;

import com.example.smmproject.dto.Request.WantedPacketRequest;
import com.example.smmproject.service.WantedPacketService;
import org.springframework.stereotype.Service;

@Service
public class WantedPacketServiceImpl implements WantedPacketService {

    @Override
    public Long calculatePrice(WantedPacketRequest wantedPacketRequest) {
        Long tiktokPost=wantedPacketRequest.getTiktokPost();
        Long tiktokStory=wantedPacketRequest.getTiktokStory();
        Long instagramPost=wantedPacketRequest.getInstagramPost();
        Long instagramStory=wantedPacketRequest.getInstagramStory();
        Long tiktokPostPrice = 5L;
        Long instagramPostPrice = 3L;
        Long instagramStoryPrice = 2L;
        Long tiktokStoryPrice = 4L;
        return (tiktokPost * tiktokPostPrice) +
                (instagramPost * instagramPostPrice) +
                (instagramStory * instagramStoryPrice) +
                (tiktokStory * tiktokStoryPrice);
    }
}
