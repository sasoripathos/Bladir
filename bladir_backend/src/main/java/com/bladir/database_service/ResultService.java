package com.bladir.database_service;

import java.util.Date;
import java.util.List;

import com.bladir.entity.Result;
import com.bladir.entity.User;
import com.bladir.exception.ResultsNotFoundException;

public interface ResultService {
	public int addResult(Result result);
	public List<Result> findAllByUserAndDate(User user, Date date) throws ResultsNotFoundException;
}
