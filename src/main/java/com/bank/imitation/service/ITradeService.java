package com.bank.imitation.service;

import com.bank.imitation.model.Trade;
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

    Result<List<Trade>> queryTrade();
}
