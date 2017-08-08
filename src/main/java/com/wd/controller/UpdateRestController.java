package com.wd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wd.dto.UpdateMassege;
import com.wd.model.Strategy;
import com.wd.service.StrategyService;

@RestController
public class UpdateRestController {
	
	@Autowired
	StrategyService strategyService;
	
	@RequestMapping(value = "/update/{appid}")
	public UpdateMassege getUpdate(@PathVariable String appid){
		
		Strategy strategy = strategyService.getByAppidAndStates(appid, "open");
		
		UpdateMassege massege = new UpdateMassege(true, strategy);
		
		return massege;
	}
	
	
}
