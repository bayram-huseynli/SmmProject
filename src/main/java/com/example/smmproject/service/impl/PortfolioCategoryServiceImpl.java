package com.example.smmproject.service.impl;

import com.example.smmproject.dto.Request.PortfolioCategoryRequest;
import com.example.smmproject.dto.Response.PortfolioCategoryResponse;
import com.example.smmproject.entity.PortfolioCategory;
import com.example.smmproject.exceptions.BadRequest;
import com.example.smmproject.exceptions.NotFoundException;
import com.example.smmproject.repository.PortfolioCategoryRepository;
import com.example.smmproject.service.PortfolioCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioCategoryServiceImpl implements PortfolioCategoryService {
    private final ModelMapper modelMapper;
    private final PortfolioCategoryRepository portfolioCategoryRepository;
    private static final String NOT_FOUND_ERROR="Not found this id";
    public static final String BAD_REQUEST_MESSAGE = "This category already exists";

    public PortfolioCategoryServiceImpl(ModelMapper modelMapper, PortfolioCategoryRepository portfolioCategoryRepository) {
        this.modelMapper = modelMapper;
        this.portfolioCategoryRepository = portfolioCategoryRepository;
    }

    @Override
    public List<PortfolioCategoryResponse> getAll() {
        List<PortfolioCategory> portfolioCategories=portfolioCategoryRepository.findAll();
        return portfolioCategories.stream().map(portfolioCategory -> modelMapper.map(portfolioCategory,PortfolioCategoryResponse.class)).toList();

    }

    @Override
    public void add(PortfolioCategoryRequest portfolioCategoryRequest) {
        if (portfolioCategoryRepository.existsByPortfolioType(portfolioCategoryRequest.portfolioType())){
            throw new BadRequest(NOT_FOUND_ERROR);
        }
        PortfolioCategory portfolioCategory=modelMapper.map(portfolioCategoryRequest,PortfolioCategory.class);
        portfolioCategoryRepository.save(portfolioCategory);
    }

    @Override
    public PortfolioCategoryResponse getById(Long id) {
        PortfolioCategory portfolioCategory=portfolioCategoryRepository.findById(id).orElseThrow(()->new NotFoundException(NOT_FOUND_ERROR));
        return modelMapper.map(portfolioCategory,PortfolioCategoryResponse.class);
    }

    @Override
    public void delete(Long id) {
        PortfolioCategory portfolioCategory=portfolioCategoryRepository.findById(id).orElseThrow(()->new NotFoundException(NOT_FOUND_ERROR));
        portfolioCategoryRepository.delete(portfolioCategory);
    }
}
