package com.hcl.hackathon.demo.mapper;

import com.hcl.hackathon.demo.domain.position.CreatePositionRequest;
import com.hcl.hackathon.demo.entity.portfolio.Position;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PositionMapper {

  public Position toEntity(CreatePositionRequest positionRequest){
    Position position = new Position();
    position.setUnits(positionRequest.getUnits());
    position.setCustomerId(positionRequest.getCustomerId());
    position.setInstrumentId(positionRequest.getInstrumentId());
    position.setTradeType(positionRequest.getTradeType());
    position.setTransactionRef(UUID.randomUUID().toString());
    return position;
  }
}
