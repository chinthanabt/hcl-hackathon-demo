package com.hcl.hackathon.demo.service.impl;

import com.hcl.hackathon.demo.configuration.exceptionHandler.NotFoundException;
import com.hcl.hackathon.demo.constants.StatusCode;
import com.hcl.hackathon.demo.domain.instrument.GetInstrumentResponse;
import com.hcl.hackathon.demo.modelconverters.InstrumentDtoConverter;
import com.hcl.hackathon.demo.models.Instrument;
import com.hcl.hackathon.demo.repository.InstrumentRepository;
import com.hcl.hackathon.demo.service.InstrumentsService;

import org.springframework.stereotype.Service;

@Service
public class InstrumentsServiceImpl implements InstrumentsService {

    private InstrumentRepository instrumentRepository;
    private InstrumentDtoConverter instrumentDtoConverter;

    public InstrumentsServiceImpl(InstrumentRepository instrumentRepository,
                                  InstrumentDtoConverter instrumentDtoConverter) {
        this.instrumentRepository = instrumentRepository;
        this.instrumentDtoConverter = instrumentDtoConverter;
    }

    @Override
    public GetInstrumentResponse getInstrumentDetails(final String name){
        //this method for get instrument details
        Instrument instrument = instrumentDtoConverter.instrumentDtoToInstrumentResponse(instrumentRepository.findByInstrumentName(name));
        GetInstrumentResponse getInstrumentResponse = new GetInstrumentResponse();
        if(instrument != null){
            getInstrumentResponse = createResponse(instrument);

        } else {
            throw new NotFoundException();
    }

        return getInstrumentResponse;
    }

    private GetInstrumentResponse createResponse(Instrument instrument){
        GetInstrumentResponse response = new GetInstrumentResponse();
        response.setData(instrument);
        response.setStatusCode(StatusCode.SUCCESS.getCode());
        response.setStatusMessage(StatusCode.SUCCESS.getDesc());
        return response;
    }

}
