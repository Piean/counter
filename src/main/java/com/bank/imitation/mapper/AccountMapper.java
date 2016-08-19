package com.bank.imitation.mapper;

import com.bank.imitation.model.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by mogu on 2016/8/18.
 */
@Repository
public interface AccountMapper {
    int openAccount(Account account);

    int updateBalance(@Param("id") String id, @Param("balance") int balance);

    Account getById(String id);
}
