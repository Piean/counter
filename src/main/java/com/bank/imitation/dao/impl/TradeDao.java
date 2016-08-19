package com.bank.imitation.dao.impl;

import com.bank.imitation.dao.ITradeDao;
import com.bank.imitation.mapper.TradeMapper;
import com.bank.imitation.model.Trade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mogu on 2016/8/18.
 */
@Service
public class TradeDao implements ITradeDao {
    @Resource
    private TradeMapper tradeMapper;

    @Override
    public int insertTrade(Trade trade) {
        return tradeMapper.insertTrade(trade);
    }
}
