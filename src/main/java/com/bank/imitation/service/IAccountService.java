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
}
