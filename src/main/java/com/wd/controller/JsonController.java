package com.wd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wd.model.Projects;
import com.wd.service.ProjectsService;

@Controller
@RequestMapping("/json")
public class JsonController {
	
	@Autowired
	ProjectsService projectsService;
	
	@RequestMapping(value = "{appid}",method = RequestMethod.GET)
	public @ResponseBody Projects getProjects(@PathVariable String appid){
		return projectsService.getProjectsByAppid(appid);
	}
	
	// Spring基于类路径中的RequestMapping和Jackson jar自动处理JSON转换   
	// 好像什么都不要做就可以了
	
}
