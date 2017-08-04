import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.wd.model.Projects;
import com.wd.service.ProjectsService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:spring.xml")
public class PageHelperTest {

	@Autowired
	ProjectsService projectsService;
	
	@Test
	public void test(){
		PageInfo<Projects> pageInfo = projectsService.getProjectsByPage(2, 2);
		
		List<Projects> list = pageInfo.getList();
		
		for (Projects projects : list) {
			System.out.println(projects.getAppid());
			System.out.println(projects.getName());
		}
		
		//OK
		
	}
}
