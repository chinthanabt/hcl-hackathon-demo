package com.hcl.hackathon.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.hackathon.demo.configuration.kafka.KafkaProducer;
import com.hcl.hackathon.demo.entity.AuditDto;
import com.hcl.hackathon.demo.entity.portfolio.Position;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService{
   private KafkaProducer kafkaProducer;
    KafkaProducerServiceImpl(KafkaProducer producer){
        this.kafkaProducer = producer;
    }
    @Override
    public void sendKafkaMessage(Position message) {
        AuditDto dto = new AuditDto();
        dto.setId(0);
        dto.setTransactionRef(message.getTransactionRef());
        dto.setInstrumentId(String.valueOf(message.getInstrumentId()));
        dto.setCustomerId(String.valueOf(message.getCustomerId()));
        dto.setTradeType(message.getTradeType().toString());
        dto.setCreatedDateTime(LocalDateTime.now());
        ObjectMapper mapper= new ObjectMapper();
        try {
            String auditAsString = mapper.writeValueAsString(dto);
            kafkaProducer.sendMessage(auditAsString);
        }catch (JsonProcessingException e){
            log.error(e.getMessage());
            //Error handling needs to be implemented such as TT creation or DEAD LETTER QUEUE
        }
    }


}
