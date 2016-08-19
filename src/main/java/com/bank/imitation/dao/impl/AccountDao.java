package com.bank.imitation.dao.impl;

import com.bank.imitation.dao.IAccountDao;
import com.bank.imitation.mapper.AccountMapper;
import com.bank.imitation.mapper.TradeMapper;
import com.bank.imitation.model.Account;
import com.bank.imitation.model.Trade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by mogu on 2016/8/18.
 */
@Service
public class AccountDao implements IAccountDao {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private TradeMapper tradeMapper;

    @Override
    public int openAccount(Account account) {
        return accountMapper.openAccount(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateBalance(String id, int amount) {
        int result = accountMapper.updateBalance(id,amount);
        if (result > 0) {
            Trade trade = new Trade();
            trade.setId(UUID.randomUUID().toString());
            trade.setInAccount(id);
            trade.setTradeAmount(amount);
            tradeMapper.insertTrade(trade);
        }
        return result;
    }
}
