package com.hcl.hackathon.demo.service;

import com.hcl.hackathon.demo.domain.instrument.GetInstrumentResponse;
import com.hcl.hackathon.demo.models.Instrument;

public interface InstrumentsService {

    GetInstrumentResponse getInstrumentDetails(String name);
}
