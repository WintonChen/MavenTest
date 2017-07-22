package com.wd.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wd.model.Projects;

public interface ProjectsMapper {
	 @Select("SELECT * FROM projects WHERE appid = #{appid}")
	 Projects getProjects(@Param("appid") String appid);
	 
	 
	 Projects selectOne(@Param("appid") String appid);
}
