package com.bank.imitation.dao;

import com.bank.imitation.model.Trade;
import com.bank.imitation.query.TradeQuery;

import java.util.List;

/**
 * Created by mogu on 2016/8/18.
 */
public interface ITradeDao {
    int insertTrade(Trade trade);

    List<Trade> queryTrade(TradeQuery query);
}
