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
     * @param outId 交易金额支出账户id
     * @param inId 交易金额流入账户id
     * @param amount 该笔交易金额
     * @return
     */
    Result<Boolean> amountTrade(String outId, String inId, int amount);
}
