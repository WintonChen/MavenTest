package com.wd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wd.dao.ProjectsDao;
import com.wd.model.Projects;

public class ProjectsDaoImpl implements ProjectsDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Projects selectOne(String appid) {
		// TODO Auto-generated method stub
		
		return (Projects) sqlSession.selectOne(
				"com.wd.dao.ProjectsDao.selectOne",appid);
	}

	@Override
	public List<Projects> selectList() {
		return  sqlSession.selectList("com.wd.dao.ProjectsDao.selectList");
	}

	@Override
	public int insert(Projects projects) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.wd.dao.ProjectsDao.insert", projects);
	}

	@Override
	public void insertList(List<Projects> projects_list) {
		// TODO Auto-generated method stub
		for (Projects projects : projects_list) {
			sqlSession.insert("com.wd.dao.ProjectsDao.insert", projects);
		}
	}

	
	@Override
	public int update(Projects projects) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String appid) {
		// TODO Auto-generated method stub

	}

}
