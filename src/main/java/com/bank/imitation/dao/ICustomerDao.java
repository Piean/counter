package com.bank.imitation.dao;

import com.bank.imitation.model.Customer;
import com.bank.imitation.query.CustomerQuery;

import java.util.List;

/**
 * Created by mogu on 2016/8/18.
 */
public interface ICustomerDao {

    Customer getById(String id);

    int insertCustomer(Customer customer);

    int updateCustomer(Customer customer);

    List<Customer> queryCustomer(CustomerQuery query);
}
