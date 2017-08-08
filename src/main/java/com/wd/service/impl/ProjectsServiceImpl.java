package com.wd.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wd.dao.ProjectsDao;
import com.wd.model.Projects;
import com.wd.service.ProjectsService;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	private  Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ProjectsDao projectsDao;
	

	@Override
	public List<Projects> showAll() {
		List<Projects> list = projectsDao.selectList();
		Projects e = new Projects();
		e.setAppid("3475672383");
		e.setName("ui89485y");
		list.add(e );
		return list;
	}




	@Override
	public Projects getByAppid(String appid) {
		Projects projects = projectsDao.selectOne(appid);
		return projects;
	}



	@Override
	public PageInfo<Projects> getByPage(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize); //开始分页
		List<Projects> list = projectsDao.selectList(); //查询操作
		PageInfo<Projects> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	
}
