package com.hcl.hackathon.demo.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDGenerator {
    public UUID get() {
        return UUID.randomUUID();
    }
}
