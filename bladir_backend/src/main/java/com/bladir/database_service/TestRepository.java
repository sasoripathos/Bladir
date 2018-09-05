package com.bladir.database_service;

import com.bladir.entity.Test;
import com.bladir.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {
    public List<Test> findAllByUserOrderByDateDesc(User user);
}
