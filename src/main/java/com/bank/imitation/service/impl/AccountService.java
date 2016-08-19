package com.bank.imitation.service.impl;

import com.bank.imitation.dao.IAccountDao;
import com.bank.imitation.model.Account;
import com.bank.imitation.result.Result;
import com.bank.imitation.result.ResultSupport;
import com.bank.imitation.service.IAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mogu on 2016/8/18.
 */
@Service
public class AccountService implements IAccountService {

    @Resource
    private IAccountDao accountDao;

    /**
     * 开户
     *
     * @param account
     * @return
     */
    @Override
    public Result<Boolean> openAccount(Account account) {
        try {
            if (null != account) {
                if (StringUtils.isBlank(account.getCustomerId())) {
                    return new ResultSupport<>("customer_error","账户必须属于某个客户");
                } else if (StringUtils.isAnyBlank(account.getCardNumber(),account.getIdCard(),account.getPhone())) {
                    return new ResultSupport<>("customer_error","账户必须属于某个客户");
                } else if (StringUtils.isBlank(account.getTradePass()) || account.getTradePass().length() != 6 || !account.getTradePass().matches("[0-9]+")) {
                    return new ResultSupport<>("pass_error","交易密码不正确，必须是6位纯数字");
                }

                Result<Boolean> result = new ResultSupport<>();
                boolean flag = accountDao.openAccount(account) > 0;
                result.setModel(flag);
                if (flag) {
                    result.setMessage("开户成功");
                } else {
                    result.setMessage("开户失败");
                }
                return result;
            } else {
                return new ResultSupport<>("null_error","参数不能为空");
            }
        } catch (Exception e) {
            return new ResultSupport<>("system_exception",e.getMessage());
        }
    }

    /**
     * 根据账户id更新余额，用于充值/提现
     *
     * @param id
     * @param balance
     * @return
     */
    @Override
    public Result<Boolean> updateBalance(String id, int balance) {
        return null;
    }
}
