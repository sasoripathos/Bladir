package com.bladir.database_service;

import com.bladir.entity.Standard;
import org.springframework.beans.factory.annotation.Autowired;

public class StandardServiceImpl implements StandardService {

    public Standard getStandardByName(String name) {
        Standard standard = null;
        try {
            standard = standardRepository.findByValuename(name);
        } catch (Exception ex){
            System.err.println("Can't find standard by name");
        }
        return standard;
    }

    @Autowired
    private StandardRepository standardRepository;
}
