package com.bank.imitation.mapper;

import com.bank.imitation.model.Counter;
import com.bank.imitation.query.CounterQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mogu on 2016/8/15.
 */
@Repository
public interface CounterMapper {
    Counter getById(String id);

    Counter getByNameAndPass(@Param("name") String userName, @Param("pass") String userPass);

    int insertCounter(Counter counter);

    int updateCounter(Counter counter);

    List<Counter> queryCounter(CounterQuery query);

    Integer countQueryCounter(CounterQuery query);
}
