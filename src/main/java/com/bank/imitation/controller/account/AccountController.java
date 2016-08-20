package com.bank.imitation.controller.account;

import com.alibaba.fastjson.JSON;
import com.bank.imitation.model.Account;
import com.bank.imitation.result.Result;
import com.bank.imitation.service.IAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yds on 2016-8-21.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private IAccountService accountService;

    @ResponseBody
    @RequestMapping("/open")
    public String openAccount(Account account) {
        Result<Boolean> result = accountService.openAccount(account);
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping("/trade")
    public String accountTrade(String outId, String inId, int amount) {
        Result<Boolean> result = accountService.amountTrade(outId, inId, amount);
        return JSON.toJSONString(result);
    }
}
