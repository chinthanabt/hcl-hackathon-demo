package com.hcl.hackathon.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuditDto {
    long id;
    String transactionRef;
    String instrumentId;
    String customerId;
    String tradeType;
    LocalDateTime createdDateTime;
}
