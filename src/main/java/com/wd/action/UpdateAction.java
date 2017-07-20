package com.wd.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8422748310704406864L;

	private String appid;

	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	
	//get log4j
	private static final Logger logger = Logger.getLogger(UpdateAction.class);

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(appid);
		logger.info(appid);
		return SUCCESS;
	}
	
//	
	
	
}
