package com.bladir.database_service;

import org.springframework.data.repository.CrudRepository;

import com.bladir.entity.Standard;

public interface StandardRepository extends CrudRepository<Standard, Integer> {
    public Standard findByValue_name(String name);
}
