package com.bladir.database_service;

import com.bladir.entity.Test;
import com.bladir.entity.User;
import com.bladir.exception.ResultsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestRepository testRepository;

    @Override
    public List<Test> getSortedTestByUser(User user) throws ResultsNotFoundException {
        List<Test> test = testRepository.findAllByUserOrderByDateDesc(user);
        if (test == null) {
            throw (new ResultsNotFoundException("User is not found"));
        } else {
            return test;
        }
    }
}
