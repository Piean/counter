package com.bank.imitation.dao;

import com.bank.imitation.model.Account;

/**
 * Created by mogu on 2016/8/18.
 */
public interface IAccountDao {
    int openAccount(Account account);

    int updateBalance(String id, int amount);
}
