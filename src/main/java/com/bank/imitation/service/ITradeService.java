package com.bank.imitation.service;

import com.bank.imitation.model.Trade;
import com.bank.imitation.query.TradeQuery;
import com.bank.imitation.result.Result;

import java.util.List;

/**
 * Created by mogu on 2016/8/18.
 */
public interface ITradeService {

    /**
     * 新增一条交易流水
     * @param trade
     * @return
     */
    Result<Boolean> insertTrade(Trade trade);

    /**
     * 条件查询交易流水
     * @param query
     * @return
     */
    Result<List<Trade>> queryTrade(TradeQuery query);
}
