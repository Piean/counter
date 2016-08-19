package com.bank.imitation.dao.impl;

import com.bank.imitation.dao.ITradeDao;
import com.bank.imitation.mapper.TradeMapper;
import com.bank.imitation.model.Trade;
import com.bank.imitation.query.TradeQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Trade> queryTrade(TradeQuery query) {
        int total = tradeMapper.countQueryTrade(query);
        query.setTotalRecord(total);
        if (0 != total) {
            return tradeMapper.queryTrade(query);
        }
        return null;
    }
}
