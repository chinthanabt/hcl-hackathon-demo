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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String symbol;
  private String instrument_name;
  private String instrument_value;
  private String instrument_type;
}
