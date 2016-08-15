package com.bank.imitation.dao;

import com.bank.imitation.model.Counter;

/**
 * Created by mogu on 2016/8/15.
 */
public interface ICounterDao {
    Counter getByNameAndPass(String userName, String userPass);
}
