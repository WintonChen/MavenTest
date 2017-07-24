package com.wd.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wd.dao.ProjectsDao;
import com.wd.mapper.ProjectsMapper;
import com.wd.model.Projects;
import com.wd.service.ProjectsService;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	private static final Logger logger = Logger.getLogger(ProjectsServiceImpl.class);
	
	@Autowired
	private ProjectsDao projectsDao;
	

	@Override
	public List<Projects> showAllProjects() {
		List<Projects> list = projectsDao.selectList();
		Projects e = new Projects();
		e.setAppid("3475672383");
		e.setName("ui89485y");
		list.add(e );
		return list;
	}

}
