package com.bank.imitation.service.impl;

import com.bank.imitation.dao.ICounterDao;
import com.bank.imitation.model.Counter;
import com.bank.imitation.query.CounterQuery;
import com.bank.imitation.result.Result;
import com.bank.imitation.result.ResultSupport;
import com.bank.imitation.service.ICounterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by mogu on 2016/8/15.
 */
@Service
public class CounterService implements ICounterService {
    @Resource
    private ICounterDao counterDao;

    @Override
    public Result<Counter> getById(String id) {
        try {
            if (StringUtils.isNotBlank(id)) {
                Result<Counter> result = new ResultSupport<>();
                result.setModel(counterDao.getById(id));
                return result;
            } else {
                return new ResultSupport<>("id_error","ID不能为空");
            }
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }

    /**
     * 根据用户名和密码获取柜员用户，用于柜员登录
     *
     * @param userName 用户名
     * @param userPass 密码
     * @return counter
     */
    @Override
    public Result<Counter> getByNameAndPass(String userName, String userPass) {
        try {
            Result<Counter> result = new ResultSupport<>();
            if (StringUtils.isNoneBlank(userName,userPass)) {
                result.setModel(counterDao.getByNameAndPass(userName,userPass));
            }
            return result;
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }

    /**
     * 新增柜员信息
     *
     * @param counter
     * @return
     */
    @Override
    public Result<Boolean> insertCounter(Counter counter) {
        try {

            if (null != counter) {
                if (StringUtils.isAnyBlank(counter.getUserName(),counter.getUserPass())) {
                    return new ResultSupport<>("data_error","新增柜员失败，柜员用户名或密码为空");
                } else if (StringUtils.isAnyBlank(counter.getName(),counter.getIdCard(),counter.getPhone())) {
                    return new ResultSupport<>("data_error","新增柜员失败，柜员姓名，身份证号，手机号均不能为空");
                } else if (counter.getSex() != 1 && counter.getSex() != 2) {
                    return new ResultSupport<>("data_error","新增柜员失败，柜员性别设置不正确");
                } else if (counter.getLevel() <= -1) {
                    return new ResultSupport<>("data_error","新增柜员失败，柜员权限级别设置不正确");
                }

                Result<Boolean> result = new ResultSupport<>();
                counter.setId(UUID.randomUUID().toString());
                boolean flag = counterDao.insertCounter(counter) > 0;
                result.setModel(flag);
                if (flag) {
                    result.setResultCode("success");
                    result.setMessage("新增柜员成功");
                } else {
                    result.setResultCode("failure");
                    result.setMessage("新增柜员失败");
                }
                return result;
            } else {
                return new ResultSupport<>("null_error","新增柜员失败，参数为空");
            }
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }

    /**
     * 更新柜员信息
     *
     * @param counter
     * @return
     */
    @Override
    public Result<Boolean> updateCounter(Counter counter) {
        try {
            if (null != counter) {
                Result<Boolean> result = new ResultSupport<>();
                boolean flag = counterDao.updateCounter(counter) > 0;
                result.setModel(flag);
                if (flag) {
                    result.setMessage("更新柜员信息成功");
                } else {
                    result.setMessage("更新柜员信息失败");
                }
                return result;
            } else {
                return new ResultSupport<>("null_error","更新柜员信息失败，参数为空");
            }

        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }

    /**
     * 根据条件，分页查询柜员信息
     *
     * @param query
     * @return
     */
    @Override
    public Result<List<Counter>> queryCounter(CounterQuery query) {
        try {
            if (null != query) {
                Result<List<Counter>> result = new ResultSupport<>();
                result.setModel(counterDao.queryCounter(query));
                return result;
            } else {
                return new ResultSupport<>("null_error","查询失败，参数为空");
            }
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }
}
