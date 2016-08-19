package com.bank.imitation.service.impl;

import com.bank.imitation.dao.ITradeDao;
import com.bank.imitation.model.Trade;
import com.bank.imitation.query.TradeQuery;
import com.bank.imitation.result.Result;
import com.bank.imitation.result.ResultSupport;
import com.bank.imitation.service.ITradeService;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by mogu on 2016/8/18.
 */
public class TradeService implements ITradeService {

    @Resource
    private ITradeDao tradeDao;

    /**
     * 新增一条交易流水
     *
     * @param trade
     * @return
     */
    @Override
    public Result<Boolean> insertTrade(Trade trade) {
        try {
            if (null != trade) {
                if (StringUtils.isBlank(trade.getInAccount()) && StringUtils.isBlank(trade.getOutAccount())) {
                    return new ResultSupport<>("account_error","改交易为涉及任何账户");
                }

                Result<Boolean> result = new ResultSupport<>();
                trade.setId(UUID.randomUUID().toString());
                boolean flag = tradeDao.insertTrade(trade) > 0;
                result.setModel(flag);
                if (flag) {
                    result.setResultCode("success");
                    result.setMessage("交易流水插入成功");
                } else {
                    result.setResultCode("failure");
                    result.setMessage("交易流水插入成功");
                }
                return result;
            } else {
                return new ResultSupport<>("null_error","参数不能为空");
            }
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }

    @Override
    public Result<List<Trade>> queryTrade(TradeQuery query) {
        try {
            if (null != query) {
                Result<List<Trade>> result = new ResultSupport<>();
                result.setModel(tradeDao.queryTrade(query));
                return result;
            } else {
                return new ResultSupport<>("null_error","查询失败，参数为空");
            }
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }
}
