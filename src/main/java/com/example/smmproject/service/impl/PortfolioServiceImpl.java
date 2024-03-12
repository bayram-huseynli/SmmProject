package com.example.smmproject.service.impl;

import com.example.smmproject.dto.request.PortfolioRequest;
import com.example.smmproject.dto.response.PortfolioResponse;
import com.example.smmproject.entity.Portfolio;
import com.example.smmproject.exceptions.NotFoundException;
import com.example.smmproject.repository.PortfolioRepository;
import com.example.smmproject.service.PortfolioService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    private final ModelMapper modelMapper;
    private final PortfolioRepository portfolioRepository;
    private static final String NOT_FOUND_ERROR="Not found this id";

    public PortfolioServiceImpl(ModelMapper modelMapper, PortfolioRepository portfolioRepository) {
        this.modelMapper = modelMapper;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public List<PortfolioResponse> getAll() {
        List<Portfolio> portfolios=portfolioRepository.findAll();
        return portfolios.stream().map(portfolio -> modelMapper.map(portfolio,PortfolioResponse.class)).toList();
    }

    @Override
    public void add(PortfolioRequest portfolioRequest) {
        Portfolio portfolio=modelMapper.map(portfolioRequest,Portfolio.class);
        portfolioRepository.save(portfolio);
    }

    @Override
    public PortfolioResponse getById(Long id) {
        Portfolio portfolio=portfolioRepository.findById(id).orElseThrow(()->new NotFoundException(NOT_FOUND_ERROR));
        return modelMapper.map(portfolio,PortfolioResponse.class);
    }

    @Override
    public void delete(Long id) {
    Portfolio portfolio=portfolioRepository.findById(id).orElseThrow(()->new NotFoundException(NOT_FOUND_ERROR));
    portfolioRepository.delete(portfolio);

    }
}
