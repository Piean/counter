package com.bank.imitation.mapper;

import com.bank.imitation.model.Trade;
import org.springframework.stereotype.Repository;

/**
 * Created by mogu on 2016/8/18.
 */
@Repository
public interface TradeMapper {
    int insertTrade(Trade trade);
}
