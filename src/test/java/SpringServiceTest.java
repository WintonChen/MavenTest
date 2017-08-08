import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wd.dao.ProjectsDao;
import com.wd.model.Projects;
import com.wd.service.ProjectsService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:spring.xml")
public class SpringServiceTest {
	
	@Autowired
	ProjectsService projectsService;
	
	@Test
	public void test(){
		List<Projects> list = projectsService.showAll();
		
		for (Projects projects : list) {
			System.out.println(projects.getAppid());
			System.out.println(projects.getName());
		}
		
	}
	
	
}
