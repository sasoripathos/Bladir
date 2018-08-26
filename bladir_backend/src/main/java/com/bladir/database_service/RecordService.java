package com.bladir.database_service;

import java.util.Date;
import java.util.List;

import com.bladir.entity.Record;
import com.bladir.entity.Test;
import com.bladir.entity.User;
import com.bladir.exception.ResultsNotFoundException;

public interface RecordService {
	public int addRecord(Record result);
	//public List<Test> findAllByUserAndDate(User user, Date date) throws ResultsNotFoundException;
}
