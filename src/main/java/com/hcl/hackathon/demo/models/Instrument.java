package com.hcl.hackathon.demo.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Instrument {
        private UUID instrumentId;
        private String instrumentName;
        private String instrumentValue;
        private String instrumentType;
    }

