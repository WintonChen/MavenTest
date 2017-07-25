package com.wd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wd.model.Projects;

public interface ProjectsMapper {

	 Projects selectOne(@Param("appid") String appid);
	 
	 List<Projects> selectList();
	 
	 int insert(Projects projects);
	 
	 void insertList(List<Projects> projects_list);
	 
	 int update(Projects projects);
	 
	 void delete(@Param("appid") String appid);
}
