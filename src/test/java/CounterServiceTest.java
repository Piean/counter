import com.bank.imitation.model.Counter;
import com.bank.imitation.query.CounterQuery;
import com.bank.imitation.result.Result;
import com.bank.imitation.service.ICounterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mogu on 2016/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CounterServiceTest {
    @Resource
    private ICounterService counterService;

    @Test
    public void testGetCounterByNameAndPass() {
        Result<Counter> counter = counterService.getByNameAndPass("admin","admin");
        System.out.println(counter);
    }

    @Test
    public void testInsert() {
        Counter counter = new Counter();
        counter.setUserName("mogu");
        counter.setUserPass("mogu");
        counter.setName("蘑菇");
        counter.setSex(1);
        counter.setIdCard("612542199204851260");
        counter.setPhone("15397222925");
        counter.setLevel(1);
        Result<Boolean> result = counterService.insertCounter(counter);
        System.out.println(result.getModel());
    }

    @Test
    public void testQueryCounter() {
        CounterQuery query = new CounterQuery();
        Result<List<Counter>> result = counterService.queryCounter(query);
        System.out.println(result.getModel());
    }
}
