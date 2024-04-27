package com.hcl.hackathon.demo.entity.portfolio;

import com.hcl.hackathon.demo.constants.InvestmentStrategy;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "portfolio")
@Data
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;
    private String customerName;
    private String portfolioNumber;
    private BigDecimal portfolioValue;
    private Double currentPerformance;
    @Enumerated(EnumType.STRING)
    private InvestmentStrategy investmentStrategy;
}
