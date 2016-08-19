package com.bank.imitation.mapper;

import com.bank.imitation.model.Customer;
import com.bank.imitation.query.CustomerQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mogu on 2016/8/18.
 */
@Repository
public interface CustomerMapper {
    Customer getById(String id);

    int insertCustomer(Customer customer);

    int updateCustomer(Customer customer);

    List<Customer> queryCustomer(CustomerQuery query);

    int countQueryCustomer(CustomerQuery query);
}
