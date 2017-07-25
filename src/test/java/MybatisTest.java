import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wd.mapper.ProjectsMapper;
import com.wd.model.Projects;

public class MybatisTest {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("mybatis.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	@Test
	public void test() {
		System.out.println("test 直接执行已映射的SQL语句  XML的语句映射方式");

		SqlSession session = sqlSessionFactory.openSession();

		try {
			Projects projects = (Projects) session.selectOne("com.wd.mapper.ProjectsMapper.selectOne", "002");
			System.out.println(projects.getAppid());
			System.out.println(projects.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test1() {
		System.out.println("test1 接口的方式 基于注解");

		SqlSession session = sqlSessionFactory.openSession();

		try {
			ProjectsMapper projectsMapper = session.getMapper(ProjectsMapper.class);
			Projects projects = projectsMapper.selectOne("jxc001");
			System.out.println(projects.getAppid());
			System.out.println(projects.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test2() {
		System.out.println("test2 接口的方式 基于注解");

		SqlSession session = sqlSessionFactory.openSession();

		try {
			ProjectsMapper projectsMapper = session.getMapper(ProjectsMapper.class);
			Projects projects = projectsMapper.selectOne("jxc001");
			System.out.println(projects.getAppid());
			System.out.println(projects.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	@Test
	public void testSelectlist() {
		System.out.println("test 直接执行已映射的SQL语句  XML的语句映射方式");

		SqlSession session = sqlSessionFactory.openSession();

		try {
			List<Projects> projects = session.selectList("com.wd.mapper.ProjectsMapper.selectList");
			for (Projects project : projects) {
				System.out.println(project.getAppid());
				System.out.println(project.getName());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	

	@Test
	public void testInsert() {
		System.out.println("test");

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Projects projects = new Projects();
			projects.setAppid("003");
			projects.setName("003");
			
			session.insert("com.wd.mapper.ProjectsMapper.insert",projects);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
