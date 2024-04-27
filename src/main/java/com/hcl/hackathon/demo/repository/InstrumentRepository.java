package com.hcl.hackathon.demo.repository;

import com.hcl.hackathon.demo.entity.portfolio.Instrument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InstrumentRepository extends CrudRepository<Instrument, Long>{
    Instrument findByInstrumentName(String name);
}
