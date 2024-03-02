package com.example.smmproject.service.impl;

import com.example.smmproject.dto.Request.WantedPacketRequest;
import com.example.smmproject.service.WantedPacketService;
import org.springframework.stereotype.Service;

@Service
public class WantedPacketServiceImpl implements WantedPacketService {

    @Override
    public Long calculatePrice(WantedPacketRequest wantedPacketRequest) {
        Long photo=wantedPacketRequest.getPhoto();
        Long video=wantedPacketRequest.getVideo();
        Long graphicPost=wantedPacketRequest.getInstagramPost();
        Long motionVideo=wantedPacketRequest.getInstagramStory();
        Long tiktokPostPrice = 5L;
        Long instagramPostPrice = 3L;
        Long instagramStoryPrice = 2L;
        Long tiktokStoryPrice = 4L;
        return (photo * tiktokPostPrice) +
                (video * instagramPostPrice) +
                (graphicPost * instagramStoryPrice) +
                (motionVideo         * tiktokStoryPrice);
    }
}
