package com.wd.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.wd.mapper.ProjectsMapper;
import com.wd.model.Projects;

public class TestAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9200297011446151162L;
	
	//get log4j
	private static final Logger logger = Logger.getLogger(TestAction.class);
	
	private String appid;

	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	
	
	@Autowired
	private ProjectsMapper projectsMapper;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(appid);
		logger.info(appid);
		
		Projects projects = projectsMapper.getProjects(appid);
		
		logger.info("name"+projects.getName());
		
		return SUCCESS;
	}

}
