package com.bank.imitation.dao.impl;

import com.bank.imitation.dao.ICounterDao;
import com.bank.imitation.mapper.CounterMapper;
import com.bank.imitation.model.Counter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mogu on 2016/8/15.
 */
@Service
public class CounterDao implements ICounterDao {
    @Resource
    private CounterMapper counterMapper;

    @Override
    public Counter getById(String id) {
        return counterMapper.getById(id);
    }

    @Override
    public Counter getByNameAndPass(String userName, String userPass) {
        return counterMapper.getByNameAndPass(userName,userPass);
    }

    @Override
    public int insertCounter(Counter counter) {
        return counterMapper.insertCounter(counter);
    }

    @Override
    public int updateCounter(Counter counter) {
        return counterMapper.updateCounter(counter);
    }
}
