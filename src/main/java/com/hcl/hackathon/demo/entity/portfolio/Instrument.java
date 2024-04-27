package com.hcl.hackathon.demo.entity.portfolio;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "instrument")
@Data
public class Instrument {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String symbol;
  private String instrumentName;
  private String instrumentValue;
  private String instrumentType;
}
