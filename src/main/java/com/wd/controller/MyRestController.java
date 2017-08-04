package com.wd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wd.model.Projects;
import com.wd.service.ProjectsService;


@RestController
public class MyRestController {

	@Autowired
	ProjectsService projectsService;
	
	@RequestMapping(value = "rest/projects/{appid}")
	public Projects getProjects(@PathVariable String appid){
		return projectsService.getProjectsByAppid(appid);
	}
	
	
	
}
