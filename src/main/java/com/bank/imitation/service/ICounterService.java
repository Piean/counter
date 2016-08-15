package com.bank.imitation.service;

import com.bank.imitation.model.Counter;

/**
 * Created by mogu on 2016/8/15.
 */
public interface ICounterService {
    /**
     * 根据用户名和密码获取柜员用户，用于柜员登录
     * @param userName 用户名
     * @param userPass 密码
     * @return counter
     */
    Counter getByNameAndPass(String userName, String userPass);
}
