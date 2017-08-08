package com.wd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.wd.model.Strategy;

public interface StrategyService {

	public List<Strategy> showAll();

	public List<Strategy> getByAppid(String appid);
	
	public Strategy getByStrategyid(String strategy_id);
	
	public Strategy getByStrategyidAndAppid(String strategy_id,String appid);
	
	public Strategy getByAppidAndStates(String appid,String states);
	
	public int insert(Strategy strategy);
	
	public void insertList(List<Strategy> list);
	
	public int update(Strategy strategy);
	
	public void delete(String strategy_id);

	public PageInfo<Strategy> getByPage(Integer pageNum, Integer pageSize);

}
