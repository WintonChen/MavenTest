package com.wd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wd.model.Projects;

public interface ProjectsDao {
	
	 Projects selectOne(@Param("appid") String appid);
	 
	 List<Projects> selectList();
	 
	 int insert(Projects projects);
	 
	 void insertList(List<Projects> list);
	 
	 int update(Projects projects);
	 
	 void delete(@Param("appid") String appid);
	 
}
