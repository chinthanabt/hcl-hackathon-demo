package com.hcl.hackathon.demo.repository;

import org.springframework.data.repository.CrudRepository;

public interface InstrumentRepository extends CrudRepository<Instrumentss, Long>{
    Instrumentss findByName(String name);

}
