package com.bank.imitation.controller.trade;

import com.alibaba.fastjson.JSON;
import com.bank.imitation.model.Trade;
import com.bank.imitation.query.TradeQuery;
import com.bank.imitation.result.Result;
import com.bank.imitation.service.ITradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yds on 2016-8-21.
 */
@Controller
@RequestMapping("/trade")
public class TradeController {
    @Resource
    private ITradeService tradeService;

    @ResponseBody
    @RequestMapping("/query_record")
    public String queryTradeRecord(TradeQuery query) {
        Result<List<Trade>> result = tradeService.queryTrade(query);
        return JSON.toJSONString(result);
    }
}
