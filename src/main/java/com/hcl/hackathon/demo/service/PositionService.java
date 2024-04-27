package com.hcl.hackathon.demo.service;

import com.hcl.hackathon.demo.domain.position.CreatePositionRequest;
import com.hcl.hackathon.demo.domain.position.CreatePositionResponse;
import com.hcl.hackathon.demo.domain.position.PositionResponse;
import com.hcl.hackathon.demo.entity.portfolio.Position;

import java.util.List;
import java.util.UUID;

public interface PositionService {

  CreatePositionResponse trade(CreatePositionRequest positionRequest);

  List<PositionResponse> findMyPositions(UUID customerId, int pageNumber, int pageSize);
}
