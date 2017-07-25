import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wd.mapper.ProjectsMapper;
import com.wd.service.ProjectsService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:spring.xml")  
public class TestMapper  extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private ProjectsMapper projectsMapper;
	
	@Test
	public void test(){
		System.out.println("test");
		projectsMapper.selectOne("002");
	}
	
}
