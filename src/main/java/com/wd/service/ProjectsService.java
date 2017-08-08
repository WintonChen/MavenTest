package com.wd.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wd.model.Projects;

public interface ProjectsService {
	
	public List<Projects> showAll();
	
	public Projects getByAppid(String appid);
	
	public PageInfo<Projects> getByPage(Integer pageNum,Integer pageSize);
	
}
