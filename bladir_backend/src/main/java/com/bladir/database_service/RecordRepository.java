package com.bladir.database_service;

import com.bladir.entity.Standard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bladir.entity.Record;
import com.bladir.entity.Test;

@Repository
public interface RecordRepository extends CrudRepository<Record, Integer> {
    public Record findRecordByTestAndStandard(Test test, Standard standard);
}
