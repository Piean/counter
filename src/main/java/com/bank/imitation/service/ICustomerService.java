package com.bank.imitation.service;

import com.bank.imitation.model.Customer;
import com.bank.imitation.query.CustomerQuery;
import com.bank.imitation.result.Result;

import java.util.List;

/**
 * Created by mogu on 2016/8/18.
 */
public interface ICustomerService {
    /**
     * 根据id获取客户信息
     * @param id
     * @return
     */
    Result<Customer> getById(String id);

    /**
     * 新增客户
     * @param customer
     * @return
     */
    Result<Boolean> insertCustomer(Customer customer);

    /**
     * 更新客户信息
     * @param customer
     * @return
     */
    Result<Boolean> updateCustomer(Customer customer);

    /**
     * 条件查询客户列表
     * @param query
     * @return
     */
    Result<List<Customer>> queryCustomer(CustomerQuery query);
}
