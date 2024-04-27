package com.hcl.hackathon.demo.controller;

import com.hcl.hackathon.demo.domain.instrument.GetInstrumentResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hcl.hackathon.demo.service.InstrumentsService;

@RestController
@RequestMapping("/instruments")
@Slf4j
public class InstrumentsController {

    private InstrumentsService instrumentsService;

    public InstrumentsController(InstrumentsService instrumentsService) {
        this.instrumentsService = instrumentsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getInstrumentDetils(@Valid final @PathVariable("page") int pageNo,
                                                      @Valid final @PathVariable("items") int items,
                                                      @Valid final @PathVariable("name") String name) throws Exception{
        log.info("Get Instrument details API invoked");
        return ResponseEntity.status(HttpStatus.OK).body(instrumentsService.getInstrumentDetails(name));
    }

}
