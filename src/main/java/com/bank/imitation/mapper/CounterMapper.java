package com.bank.imitation.mapper;

import com.bank.imitation.model.Counter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by mogu on 2016/8/15.
 */
@Repository
public interface CounterMapper {
    Counter getByNameAndPass(@Param("name") String userName, @Param("pass") String userPass);

    int insertCounter(Counter counter);

    int updateCounter(Counter counter);
}
