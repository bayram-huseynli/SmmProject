package com.example.smmproject.controller;

import com.example.smmproject.dto.request.FeedBackRequest;
import com.example.smmproject.dto.response.FeedBackResponse;
import com.example.smmproject.service.FeedBackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedBack")
public class FeedBackController {

    private final FeedBackService feedBackService;

    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<FeedBackResponse>> findAll(){
        return new ResponseEntity<>(feedBackService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public void create (@RequestBody FeedBackRequest feedBackRequest){
        feedBackService.create(feedBackRequest);
    }

    @GetMapping("getById/{id}")
    public FeedBackResponse getById(@PathVariable Long id){
        return feedBackService.getById(id);
    }

    @PutMapping("update/{id}")
    public void update(@PathVariable Long id,@RequestBody FeedBackRequest feedBackRequest){
        feedBackService.update(id, feedBackRequest);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        feedBackService.delete(id);
    }

}
