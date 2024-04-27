package com.hcl.hackathon.demo.service;

import com.hcl.hackathon.demo.configuration.exceptionHandler.NotFoundException;
import com.hcl.hackathon.demo.constants.InvestmentStrategy;
import com.hcl.hackathon.demo.constants.StatusCode;
import com.hcl.hackathon.demo.domain.portfolio.PortfolioResponse;
import com.hcl.hackathon.demo.entity.portfolio.Portfolio;
import com.hcl.hackathon.demo.repository.PortfolioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;
    public PortfolioResponse getCustomerPortfolio(UUID customerId){
        final Optional<Portfolio> byId = portfolioRepository.findById(customerId);
        PortfolioResponse response = new PortfolioResponse();
        if(byId.isPresent()){
            com.hcl.hackathon.demo.domain.portfolio.Portfolio portfolio = new com.hcl.hackathon.demo.domain.portfolio.Portfolio();
            BeanUtils.copyProperties(byId.get(), portfolio);
            response.setData(byId.get());
            response.setStatusCode(StatusCode.SUCCESS.getCode());
            response.setStatusMessage(StatusCode.SUCCESS.getDesc());
        } else {
            throw new NotFoundException();
        }
        return response;
    }

    public void create(){
        Portfolio portfolio = new Portfolio();
        portfolio.setCustomerName("Test");
        portfolio.setPortfolioValue(new BigDecimal(100));
        portfolio.setPortfolioNumber("5555444444");
        portfolio.setInvestmentStrategy(InvestmentStrategy.SAFE);
        portfolio.setCurrentPerformance(20d);
        portfolioRepository.save(portfolio);
    }
}
