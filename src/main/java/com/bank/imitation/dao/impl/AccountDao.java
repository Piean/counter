package com.bank.imitation.dao.impl;

import com.bank.imitation.dao.IAccountDao;
import com.bank.imitation.mapper.AccountMapper;
import com.bank.imitation.model.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mogu on 2016/8/18.
 */
@Service
public class AccountDao implements IAccountDao {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public int openAccount(Account account) {
        return accountMapper.openAccount(account);
    }

    @Override
    public int updateBalance(String id, int balance) {
        return accountMapper.updateBalance(id,balance);
    }
}
