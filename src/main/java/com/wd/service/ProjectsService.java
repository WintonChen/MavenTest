package com.wd.service;

import java.util.List;

import com.wd.model.Projects;

public interface ProjectsService {
	
	public List<Projects> showAllProjects();
	
	public Projects getProjectsByAppid(String appid);
}
