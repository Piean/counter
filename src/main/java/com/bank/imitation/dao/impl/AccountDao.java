package com.bank.imitation.dao.impl;

import com.bank.imitation.dao.IAccountDao;
import com.bank.imitation.mapper.AccountMapper;
import com.bank.imitation.mapper.TradeMapper;
import com.bank.imitation.model.Account;
import com.bank.imitation.model.Trade;
import org.apache.commons.lang3.StringUtils;
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
    public int amountTrade(String outId, String inId, int amount) {
        int result = 0;
        Trade trade = new Trade();
        trade.setId(UUID.randomUUID().toString());
        //充值
        if (StringUtils.isBlank(outId)) {
            result = accountMapper.updateBalance(inId,amount);
            if (result > 0) {
                trade.setInAccount(inId);
                trade.setTradeAmount(amount);
            }
        }
        //提现
        else if (StringUtils.isBlank(inId)) {
            result = accountMapper.updateBalance(outId,0-amount);
            if (result > 0) {
                trade.setOutAccount(outId);
                trade.setTradeAmount(amount);
            }
        }
        //转账
        else {
            result = accountMapper.updateBalance(inId,amount) + accountMapper.updateBalance(outId,0-amount);
            if (result == 2) {
                trade.setOutAccount(outId);
                trade.setInAccount(inId);
                trade.setTradeAmount(amount);
            }
        }
        tradeMapper.insertTrade(trade);
        return result;
    }
}
