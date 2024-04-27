package com.hcl.hackathon.demo.models;

import java.util.UUID;

@Data
public class Instrument {
        private UUID instrument_id;
        private String instrument_name;
        private String instrument_value;
        private String instrument_type;
    }

