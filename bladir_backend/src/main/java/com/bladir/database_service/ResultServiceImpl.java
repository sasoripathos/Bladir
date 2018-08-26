package com.bladir.database_service;

import com.bladir.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultServiceImpl implements ResultService {

	@Override
	public int addResult(Result result) {
		try {
			resultRepository.save(result);
		} catch (Exception ex) {
			System.err.println("Can't find result");
		}
		return result.getId();
	}

	@Autowired
	private ResultRepository resultRepository;
}
