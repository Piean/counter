package com.bank.imitation.dao.impl;

import com.bank.imitation.dao.ICustomerDao;
import com.bank.imitation.mapper.CustomerMapper;
import com.bank.imitation.model.Customer;
import com.bank.imitation.query.CustomerQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mogu on 2016/8/18.
 */
@Service
public class CustomerDao implements ICustomerDao {
    @Resource
    private CustomerMapper customerMapper;


    @Override
    public Customer getById(String id) {
        return customerMapper.getById(id);
    }

    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insertCustomer(customer);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public List<Customer> queryCustomer(CustomerQuery query) {
        Integer temp = customerMapper.countQueryCustomer(query);
        int total = 0;
        if (null != temp) {
            total = temp;
            query.setTotalRecord(total);
            return customerMapper.queryCustomer(query);
        } else {
            query.setTotalRecord(total);
            return null;
        }
    }
}
