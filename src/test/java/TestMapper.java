import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wd.service.ProjectsService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:spring.xml")  
public class TestMapper  extends AbstractJUnit4SpringContextTests{
	
	private ProjectsService projectsService;
	
	@Test
	public void test(){
		System.out.println("test");
//		projectsService.queryById("111");
	}
	
}
