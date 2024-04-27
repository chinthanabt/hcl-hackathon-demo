package com.hcl.hackathon.demo.entity.portfolio;

import com.hcl.hackathon.demo.constants.InvestmentStrategy;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "portfolio")
@Data
public class Portfolio {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID customerId;
    private String customerName;
    private String portfolioNumber;
    private BigDecimal portfolioValue;
    private Double currentPerformance;
    @Enumerated(EnumType.STRING)
    private InvestmentStrategy investmentStrategy;
}
