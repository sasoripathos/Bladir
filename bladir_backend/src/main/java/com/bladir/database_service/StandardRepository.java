package com.bladir.database_service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bladir.entity.Standard;

@Repository
public interface StandardRepository extends CrudRepository<Standard, String> {
    public Standard findByValuename(String name);
}
