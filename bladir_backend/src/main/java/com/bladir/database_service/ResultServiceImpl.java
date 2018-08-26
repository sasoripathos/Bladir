package com.bladir.database_service;

import com.bladir.entity.Result;
import com.bladir.entity.User;
import com.bladir.exception.ResultsNotFoundException;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepository resultRepository;
	
	@Override
	public int addResult(Result result) {
		try {
			resultRepository.save(result);
		} catch (Exception ex) {
			System.err.println("Can't find result");
		}
		return result.getId();
	}

	@Override
	public List<Result> findAllByUserAndDate(User user, Date date) throws ResultsNotFoundException {
		List<Result> results = resultRepository.findAllByUserAndDate(user, date);
		if (results == null || results.size() == 0) {
			throw new ResultsNotFoundException("No result available for given user and date");
		}
		return resultRepository.findAllByUserAndDate(user, date);
	}
}
