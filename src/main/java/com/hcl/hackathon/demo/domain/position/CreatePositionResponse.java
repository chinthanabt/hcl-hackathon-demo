package com.hcl.hackathon.demo.domain.position;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hcl.hackathon.demo.constants.TradeType;
import com.hcl.hackathon.demo.entity.portfolio.Instrument;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePositionResponse {

  private long instrumentId;
  private int units;
}
