package com.bank.imitation.controller.counter;

import com.bank.imitation.model.Counter;
import com.bank.imitation.service.ICounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by mogu on 2016/8/15.
 */
@Controller
@RequestMapping("/counter")
public class CounterController {
    @Resource
    private ICounterService counterService;

    @RequestMapping("/index")
    public String goIndex(String userName, String userPass) {
        return "login.html";
    }

    @ResponseBody
    @RequestMapping("/login")
    public Counter counterLogin(String userName, String userPass) {
        return null;
    }
}
