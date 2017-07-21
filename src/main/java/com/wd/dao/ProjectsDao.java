package com.wd.dao;

import com.wd.model.Projects;

public interface ProjectsDao {
	
	Projects queryById(String appid);
}
