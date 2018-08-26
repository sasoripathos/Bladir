package com.bladir.database_service;

import com.bladir.entity.Record;
import com.bladir.entity.User;
import com.bladir.exception.ResultsNotFoundException;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
	public List<Record> findAllByUserAndDate(User user, Date date) throws ResultsNotFoundException {
		List<Record> results = recordRepository.findAllByUserAndDate(user, date);
		if (results == null || results.size() == 0) {
			throw new ResultsNotFoundException("No result available for given user and date");
		}
		return recordRepository.findAllByUserAndDate(user, date);
	}
}
