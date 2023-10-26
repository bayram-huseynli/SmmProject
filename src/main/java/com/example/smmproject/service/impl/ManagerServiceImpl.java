package com.example.smmproject.service.impl;

import com.example.smmproject.dto.Request.ManagerRequest;
import com.example.smmproject.dto.Response.ManagerResponse;
import com.example.smmproject.entity.Manager;
import com.example.smmproject.repository.ManagerRepository;
import com.example.smmproject.service.ManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ModelMapper modelMapper;
    private final ManagerRepository managerRepository;


    public ManagerServiceImpl(ModelMapper modelMapper, ManagerRepository managerRepository) {
        this.modelMapper = modelMapper;
        this.managerRepository = managerRepository;
    }

    public List<ManagerResponse> findAll(){
       return managerRepository
               .findAll()
               .stream()
               .map(manager -> modelMapper.map(manager,ManagerResponse.class))
               .toList();
    }

    public void create(ManagerRequest managerRequest){
        Manager manager=modelMapper.map(managerRequest,Manager.class);
        managerRepository.save(manager);
    }

    @Override
    public ManagerResponse getById(Long id) {
        Manager manager=managerRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return modelMapper.map(manager,ManagerResponse.class);
    }

    @Override
    public ManagerResponse update(Long id, ManagerRequest managerRequest) {
    managerRepository.findById(id).orElseThrow(()-> new RuntimeException());
    Manager manager=modelMapper.map(managerRequest,Manager.class);
    manager.setId(id);
    return modelMapper.map(managerRepository.save(manager),ManagerResponse.class);
    }

    @Override
    public void delete(Long id) {

        Manager manager=managerRepository.findById(id).orElseThrow(()-> new RuntimeException());
        managerRepository.delete(manager);

    }


}
