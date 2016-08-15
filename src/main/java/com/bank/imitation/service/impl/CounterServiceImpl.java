package com.bank.imitation.service.impl;

import com.bank.imitation.dao.ICounterDao;
import com.bank.imitation.model.Counter;
import com.bank.imitation.service.ICounterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mogu on 2016/8/15.
 */
@Service
public class CounterServiceImpl implements ICounterService {
    @Resource
    private ICounterDao counterDao;
    /**
     * 根据用户名和密码获取柜员用户，用于柜员登录
     *
     * @param userName 用户名
     * @param userPass 密码
     * @return counter
     */
    public Counter getByNameAndPass(String userName, String userPass) {
        if (StringUtils.isNoneBlank(userName,userPass)) {
            return counterDao.getByNameAndPass(userName,userPass);
        }
        return null;
    }
}
