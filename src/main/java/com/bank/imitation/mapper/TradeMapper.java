package com.bank.imitation.mapper;

import com.bank.imitation.model.Trade;
import com.bank.imitation.query.TradeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mogu on 2016/8/18.
 */
@Repository
public interface TradeMapper {
    int insertTrade(Trade trade);

    List<Trade> queryTrade(TradeQuery query);

    int countQueryTrade(TradeQuery query);
}
