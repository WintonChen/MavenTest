package com.wd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wd.model.Download;

public interface DownloadDao {
	
	List<Download> selectList();
	
	List<Download> seletctByStrategyid(@Param("strategy_id") String strategy_id);
	
	List<Download> seletctByTime(@Param("beginTime") String beginTime,@Param("endTime") String endTime);
	
	int insert(Download download);
	
}
