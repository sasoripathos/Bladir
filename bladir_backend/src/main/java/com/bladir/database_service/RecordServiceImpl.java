package com.bladir.database_service;

import com.bladir.entity.Record;
import com.bladir.entity.Standard;
import com.bladir.entity.Test;
import com.bladir.exception.ResultsNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordRepository recordRepository;
	
	@Override
	public int addRecord(Record result) {
		try {
			recordRepository.save(result);
		} catch (Exception ex) {
			System.err.println("Can't find result");
		}
		return result.getId();
	}

	@Override
	public Record findRecordByTestAndStandard(Test test, Standard standard) throws ResultsNotFoundException {
		Record record = recordRepository.findRecordByTestAndStandard(test, standard);
		if (record == null) {
			throw (new ResultsNotFoundException("Record is not found"));
		} else {
			return record;
		}
	}
}
