package com.hcl.hackathon.demo.service;

import com.hcl.hackathon.demo.configuration.exceptionHandler.TradingException;
import com.hcl.hackathon.demo.constants.TradeType;
import com.hcl.hackathon.demo.domain.position.CreatePositionRequest;
import com.hcl.hackathon.demo.domain.position.CreatePositionResponse;
import com.hcl.hackathon.demo.domain.position.PositionItem;
import com.hcl.hackathon.demo.domain.position.PositionResponse;
import com.hcl.hackathon.demo.entity.portfolio.Instrument;
import com.hcl.hackathon.demo.entity.portfolio.Position;
import com.hcl.hackathon.demo.mapper.PositionMapper;
import com.hcl.hackathon.demo.repository.PositionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {

  private PositionRepository positionRepository;
  private PositionMapper positionMapper;

  @Override
  @Transactional
  public CreatePositionResponse trade(CreatePositionRequest positionRequest) {
    Position position;
    var previousPositionOptional = positionRepository.getByCustomerIdAndInstrumentId(positionRequest.getCustomerId(), positionRequest.getInstrumentId());
    if (previousPositionOptional.isPresent()) {
      //update instrument
      position = updatePositionInstrument(previousPositionOptional.get(), positionRequest);
    } else {
      if (TradeType.sell.equals(positionRequest.getTradeType())) {
        throw new TradingException("100002", "You don't have enough instrument to sell");
      }
      //handle BUY instrument
      position = positionMapper.toEntity(positionRequest);
      position = positionRepository.save(position);
      if(null!=position){

      }
    }
    CreatePositionResponse response = new CreatePositionResponse();
    response.setInstrumentId(positionRequest.getInstrumentId());
    response.setUnits(position.getUnits());
    return response;
  }

  private Position updatePositionInstrument(Position previousPosition, CreatePositionRequest positionRequest) {

    if (TradeType.buy.equals(positionRequest.getTradeType())) {
      previousPosition.setUnits(previousPosition.getUnits() + positionRequest.getUnits());
      return positionRepository.save(previousPosition);
    }

    //SELL handle
    Position position;
    int newUnit = previousPosition.getUnits() - positionRequest.getUnits();
    if (newUnit < 0) {
      throw new TradingException("100003", "You don't have enough instrument to sell");
    }
    if (newUnit == 0) {
      positionRepository.delete(previousPosition);
      position = previousPosition;
      position.setUnits(0);
    } else {
      previousPosition.setUnits(newUnit);
      position = positionRepository.save(previousPosition);
    }
    return position;
  }

  public List<PositionResponse> findMyPositions(UUID customerId, int pageNumber, int pageSize) {
    var pageable = PageRequest.of(pageNumber, pageSize);
    var data = positionRepository.findPositionByCustomerId(customerId, pageable);
    return data.stream().map(p -> {
      PositionResponse positionResponse = new PositionResponse();
      positionResponse.setInstrumentId(p.getInstrumentId());
      positionResponse.setUnits(p.getUnits());
      return positionResponse;
    }).collect(Collectors.toList());
  }
}
