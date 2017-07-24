package com.wd.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wd.mapper.ProjectsMapper;
import com.wd.model.Projects;
import com.wd.service.ProjectsService;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	private static final Logger logger = Logger.getLogger(ProjectsServiceImpl.class);
	
//	@Autowired
//	private ProjectsMapper projectsMapper;
	
	@Override
	public Projects queryById(String appid) {
		// TODO Auto-generated method stub
		logger.info("queryById:"+appid);
//		return projectsMapper.getProjects(appid);
		return null;
	}

}
