package com.bank.imitation.service;

import com.bank.imitation.model.Account;
import com.bank.imitation.result.Result;

/**
 * Created by mogu on 2016/8/18.
 */
public interface IAccountService {

    /**
     * 开户
     * @param account
     * @return
     */
    Result<Boolean> openAccount(Account account);

    /**
     * 根据账户id更新余额，用于充值转账
     * @param id
     * @param balance
     * @return
     */
    Result<Boolean> updateBalance(String id, int balance);
}
