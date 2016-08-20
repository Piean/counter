package com.bank.imitation.controller.customer;

import com.alibaba.fastjson.JSON;
import com.bank.imitation.model.Customer;
import com.bank.imitation.query.CustomerQuery;
import com.bank.imitation.result.Result;
import com.bank.imitation.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yds on 2016-8-19.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private ICustomerService customerService;

    @ResponseBody
    @RequestMapping("/query_list")
    public String getCustomerList(CustomerQuery query) {
        Result<List<Customer>> result = customerService.queryCustomer(query);
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping("/add")
    public String addCustomer(Customer customer) {
        Result<Boolean> result = customerService.insertCustomer(customer);
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping("/get")
    public String getCustomer(String id) {
        Result<Customer> result = customerService.getById(id);
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateCustomer(Customer customer) {
        Result<Boolean> result = customerService.updateCustomer(customer);
        return JSON.toJSONString(result);
    }
}
