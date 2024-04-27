package com.hcl.hackathon.demo.modelconverters;

import org.springframework.stereotype.Component;
import com.hcl.hackathon.demo.models.Instrument;
import com.hcl.hackathon.demo.utils.UUIDGenerator;


@Component
public class InstrumentDtoConverter {
    private UUIDGenerator uuidGenerator;

    public InstrumentDtoConverter(UUIDGenerator uuidGenerator) {
        this.uuidGenerator = uuidGenerator;
    }

    public Instrument instrumentDtoToInstrumentResponse(com.hcl.hackathon.demo.entity.portfolio.Instrument repoInstrument){
        final Instrument instrument = new Instrument();
        instrument.setInstrumentId(repoInstrument.getId());
        instrument.setInstrumentName(repoInstrument.getInstrumentName());
        instrument.setInstrumentValue(repoInstrument.getInstrumentValue());
        instrument.setInstrumentType(repoInstrument.getInstrumentType());
        return instrument;

    }
}
