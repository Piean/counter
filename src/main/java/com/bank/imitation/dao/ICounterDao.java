package com.bank.imitation.dao;

import com.bank.imitation.model.Counter;
import com.bank.imitation.query.CounterQuery;

import java.util.List;

/**
 * Created by mogu on 2016/8/15.
 */
public interface ICounterDao {
    Counter getById(String id);

    Counter getByNameAndPass(String userName, String userPass);

    int insertCounter(Counter counter);

    int updateCounter(Counter counter);

    List<Counter> queryCounter(CounterQuery query);
}
