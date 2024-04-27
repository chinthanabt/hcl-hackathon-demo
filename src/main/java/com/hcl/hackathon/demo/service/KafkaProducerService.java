package com.hcl.hackathon.demo.service;

import com.hcl.hackathon.demo.entity.portfolio.Position;

public interface KafkaProducerService {
    public void sendKafkaMessage(Position message);
}
