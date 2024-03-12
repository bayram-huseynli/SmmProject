package com.example.smmproject.controller;

import com.example.smmproject.dto.request.ManagerRequest;
import com.example.smmproject.dto.response.ManagerResponse;
import com.example.smmproject.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manager")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<ManagerResponse>> findAll(){
        return new ResponseEntity<>(managerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public void create (@RequestBody ManagerRequest managerRequest){
        managerService.create(managerRequest);
    }

    @GetMapping("getById/{id}")
    public ManagerResponse getById(@PathVariable Long id){
        return managerService.getById(id);
    }

    @PutMapping("update/{id}")
    public void update(@PathVariable Long id,@RequestBody ManagerRequest managerRequest){
        managerService.update(id,managerRequest);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        managerService.delete(id);
    }

}
