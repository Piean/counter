package com.bank.imitation.service.impl;

import com.bank.imitation.dao.ICustomerDao;
import com.bank.imitation.model.Customer;
import com.bank.imitation.query.CustomerQuery;
import com.bank.imitation.result.Result;
import com.bank.imitation.result.ResultSupport;
import com.bank.imitation.service.ICustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by mogu on 2016/8/18.
 */
@Service
public class CustomerService implements ICustomerService {
    @Resource
    private ICustomerDao customerDao;

    /**
     * 根据id获取客户信息
     *
     * @param id
     * @return
     */
    @Override
    public Result<Customer> getById(String id) {
        try {
            if (StringUtils.isNotBlank(id)) {
                Result<Customer> result = new ResultSupport<>();
                result.setModel(customerDao.getById(id));
                return result;
            } else {
                return new ResultSupport<>("id_error","ID不能为空");
            }
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }

    /**
     * 新增客户
     *
     * @param customer
     * @return
     */
    @Override
    public Result<Boolean> insertCustomer(Customer customer) {
        try {
            if (null != customer) {
                if (StringUtils.isAnyBlank(customer.getUserName(),customer.getUserPass())) {
                    return new ResultSupport<>("data_error","新增客户失败，客户的用户名和密码不能为空");
                } else if (StringUtils.isAnyBlank(customer.getName(),customer.getIdCard(),customer.getPhone())) {
                    return new ResultSupport<>("data_error","新增客户失败，客户的姓名，身份证号，手机号均不能为空");
                } else if (customer.getSex() != 1 && customer.getSex() != 2) {
                    return new ResultSupport<>("data_error","新增客户失败，客户性别设置不正确");
                }

                Result<Boolean> result = new ResultSupport<>();
                customer.setId(UUID.randomUUID().toString());
                boolean flag = customerDao.insertCustomer(customer) > 0;
                result.setModel(flag);
                if (flag) {
                    result.setResultCode("success");
                    result.setMessage("新增客户成功");
                } else {
                    result.setResultCode("failure");
                    result.setMessage("新增客户失败");
                }
                return result;
            }
            return new ResultSupport<>("null_error","参数不能为空");
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }

    /**
     * 更新客户信息
     *
     * @param customer
     * @return
     */
    @Override
    public Result<Boolean> updateCustomer(Customer customer) {
        try {
            if (null != customer) {
                Result<Boolean> result = new ResultSupport<>();
                boolean flag = customerDao.updateCustomer(customer) > 0;
                result.setModel(flag);
                if (flag) {
                    result.setMessage("更新客户信息成功");
                } else {
                    result.setMessage("更新客户信息失败");
                }return result;

            } else {
                return new ResultSupport<>("null_error","更新客户信息失败，参数为空");
            }

        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }

    /**
     * 条件查询客户列表
     *
     * @param query
     * @return
     */
    @Override
    public Result<List<Customer>> queryCustomer(CustomerQuery query) {
        try {
            if (null != query) {
                Result<List<Customer>> result = new ResultSupport<>();
                result.setModel(customerDao.queryCustomer(query));
                return result;
            } else {
                return new ResultSupport<>("null_error","查询失败，参数为空");
            }
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }
}
