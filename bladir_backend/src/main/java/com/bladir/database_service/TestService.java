package com.bladir.database_service;

import com.bladir.entity.Test;
import com.bladir.entity.User;
import com.bladir.exception.ResultsNotFoundException;

import java.util.List;

public interface TestService {
    public List<Test> getSortedTestByUser(User user) throws ResultsNotFoundException;
}
