import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wd.model.Strategy;
import com.wd.service.StrategyService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:spring.xml")
public class StrategyServiceTest {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private StrategyService strategyService;
	
	@Test
	public void showAll(){
		List<Strategy> list = strategyService.showAll();
		
		for (Strategy temp : list) {
			System.out.println(temp.getStrategy_id());
			System.out.println(temp.getAppid());
			System.out.println(temp.getName());
		}
		
	}
	
	@Test
	public void getByAppid(){
		List<Strategy> list = strategyService.getByAppid("jxc001");
		
		for (Strategy temp : list) {
			System.out.println(temp.getStrategy_id());
			System.out.println(temp.getAppid());
			System.out.println(temp.getName());
		}
	}
	
	
	
	
	
}
