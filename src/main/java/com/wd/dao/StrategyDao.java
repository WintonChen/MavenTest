package com.wd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wd.model.Strategy;

public interface StrategyDao {
	
	 List<Strategy> selectByAppid(@Param("appid") String appid);
	 
	 Strategy seletctByStrategyid(@Param("strategy_id") String strategy_id);
	
	 Strategy selectByAppidAndStates(@Param("appid") String appid,@Param("states") String states);
	 
	 Strategy selectByStrategyidAndAppid(@Param("strategy_id") String strategy_id,@Param("appid") String appid);
	 
	 List<Strategy> selectList();
	 
	 
	 int insert(Strategy strategy);
	 
	 void insertList(List<Strategy> list);
	 
	 int update(Strategy strategy);
	 
	 void delete(@Param("strategy_id") String strategy_id);
}
