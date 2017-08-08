package com.wd.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wd.dao.StrategyDao;
import com.wd.model.Strategy;
import com.wd.service.StrategyService;

@Service
public class StrategyServiceImpl implements StrategyService{

	private  Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private StrategyDao strategyDao;
	
	@Override
	public List<Strategy> showAll() {
		return strategyDao.selectList();
	}

	@Override
	public List<Strategy> getByAppid(String appid) {
		return strategyDao.selectByAppid(appid);
	}

	@Override
	public Strategy getByStrategyid(String strategy_id) {
		return strategyDao.seletctByStrategyid(strategy_id);
	}

	@Override
	public Strategy getByAppidAndStates(String appid, String states) {
		return strategyDao.selectByAppidAndStates(appid, states);
	}
	
	@Override
	public Strategy getByStrategyidAndAppid(String strategy_id, String appid) {
		return strategyDao.selectByStrategyidAndAppid(strategy_id, appid);
	}
	
	@Override
	public int insert(Strategy strategy) {
		return strategyDao.insert(strategy);
	}

	@Override
	public void insertList(List<Strategy> list) {
		strategyDao.insertList(list);
	}

	@Override
	public int update(Strategy strategy) {
		return strategyDao.update(strategy);
	}

	@Override
	public void delete(String strategy_id) {
		strategyDao.delete(strategy_id);
	}

	@Override
	public PageInfo<Strategy> getByPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize); //开始分页
		List<Strategy> list = strategyDao.selectList(); //查询操作
		PageInfo<Strategy> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}





}
