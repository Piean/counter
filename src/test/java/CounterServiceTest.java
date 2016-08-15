import com.bank.imitation.model.Counter;
import com.bank.imitation.service.ICounterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
        Counter counter = counterService.getByNameAndPass("admin","admin");
        System.out.println(counter);
    }
}
