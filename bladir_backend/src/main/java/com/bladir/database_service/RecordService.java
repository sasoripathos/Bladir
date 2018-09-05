package com.bladir.database_service;

import com.bladir.entity.Record;
import com.bladir.entity.Standard;
import com.bladir.entity.Test;

import com.bladir.exception.ResultsNotFoundException;

public interface RecordService {
	public int addRecord(Record result);

	public Record findRecordByTestAndStandard(Test test, Standard standard) throws ResultsNotFoundException;
}
