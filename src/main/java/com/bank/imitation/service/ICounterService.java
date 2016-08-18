package com.bank.imitation.service;

import com.bank.imitation.model.Counter;
import com.bank.imitation.result.Result;

/**
 * Created by mogu on 2016/8/15.
 */
public interface ICounterService {

    /**
     * 根据柜员id获取柜员信息
     * @param id
     * @return
     */
    Result<Counter> getById(String id);

    /**
     * 根据用户名和密码获取柜员用户，用于柜员登录
     * @param userName 用户名
     * @param userPass 密码
     * @return counter
     */
    Result<Counter> getByNameAndPass(String userName, String userPass);

    /**
     * 新增柜员信息
     * @param counter
     * @return
     */
    Result<Boolean> insertCounter(Counter counter);

    /**
     * 更新柜员信息
     * @param counter
     * @return
     */
    Result<Boolean> updateCounter(Counter counter);
}
