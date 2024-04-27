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
        instrument.setInstrument_id(repoInstrument.getInstrument_id());
        instrument.setInstrument_name(repoInstrument.getInstrument_name);
        instrument.setInstrument_value(repoInstrument.getInstrument_value);
        instrument.setInstrument_type(repoInstrument.getInstrument_type());
        return instrument;

    }
}
