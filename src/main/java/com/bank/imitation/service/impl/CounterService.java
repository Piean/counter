package com.bank.imitation.service.impl;

import com.bank.imitation.dao.ICounterDao;
import com.bank.imitation.model.Counter;
import com.bank.imitation.result.Result;
import com.bank.imitation.result.ResultSupport;
import com.bank.imitation.service.ICounterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by mogu on 2016/8/15.
 */
@Service
public class CounterService implements ICounterService {
    @Resource
    private ICounterDao counterDao;
    /**
     * 根据用户名和密码获取柜员用户，用于柜员登录
     *
     * @param userName 用户名
     * @param userPass 密码
     * @return counter
     */
    public Result<Counter> getByNameAndPass(String userName, String userPass) {
        try {
            Result<Counter> result = new ResultSupport<>();
            if (StringUtils.isNoneBlank(userName,userPass)) {
                Counter counter = counterDao.getByNameAndPass(userName,userPass);
                if (null != counter) {
                    result.setModel(counter);
                    result.setMessage("登录成功");
                } else {
                    result.setMessage("登录失败，用户名或密码错误");
                }
            } else {
                result.setMessage("登录失败，用户名或密码为空");
            }
            return result;
        } catch (Exception e) {
            return new ResultSupport<>(e.getMessage(),"登录失败，系统异常");
        }
    }

    /**
     * 新增柜员信息
     *
     * @param counter
     * @return
     */
    public Result<Boolean> insertCounter(Counter counter) {
        try {
            Result<Boolean> result = new ResultSupport<>();
            if (null != counter) {
                if (StringUtils.isNoneBlank(counter.getUserName(),counter.getUserPass())) {
                    counter.setId(UUID.randomUUID().toString());
                    boolean flag = counterDao.insertCounter(counter) > 0;
                    result.setModel(flag);
                    if (flag) {
                        result.setMessage("新增柜员成功");
                    } else {
                        result.setMessage("新增柜员失败");
                    }
                } else {
                    result.setModel(false);
                    result.setMessage("新增柜员失败，柜员用户名或密码为空");
                }
            } else {
                result.setModel(false);
                result.setMessage("新增柜员失败，参数为空");
            }
            return result;
        } catch (Exception e) {
            return new ResultSupport<>(e.getMessage(),"新增失败，系统异常");
        }
    }

    /**
     * 更新柜员信息
     *
     * @param counter
     * @return
     */
    public Result<Boolean> updateCounter(Counter counter) {
        try {
            Result<Boolean> result = new ResultSupport<>();
            if (null != counter) {
                boolean flag = counterDao.updateCounter(counter) > 0;
                result.setModel(flag);
                if (flag) {
                    result.setMessage("更新柜员成功");
                } else {
                    result.setMessage("更新柜员失败");
                }
            } else {
                result.setModel(false);
                result.setMessage("更新柜员失败，参数为空");
            }
            return result;
        } catch (Exception e) {
            return new ResultSupport<>(e.getMessage(),"更新失败，系统异常");
        }
    }
}
