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

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:spring.xml")
public class SpringDaoTest {
	
	@Autowired
	ProjectsDao projectsDao;
	
	@Test
	public void test(){
		Projects p = projectsDao.selectOne("jxc001");
		System.out.println(p.getAppid());
	}
	
	@Test
	public void test1(){
		Projects projects1 = new Projects();
		projects1.setAppid("008");
		projects1.setName("008");
		Projects projects2 = new Projects();
		projects2.setAppid("009");
		projects2.setName("009");
		List<Projects> projects_list = new ArrayList<Projects>();
		projects_list.add(projects1);
		projects_list.add(projects2);
		projectsDao.insertList(projects_list);
	}
}
