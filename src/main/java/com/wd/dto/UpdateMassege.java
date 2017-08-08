package com.wd.dto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.wd.model.Strategy;

public class UpdateMassege {

	private String appid;
	
	private String url;
	
	private int versionCode;
	
	private String updateMessage;
	
	public UpdateMassege(){
		
	}
	
	public UpdateMassege(boolean success,Strategy strategy){
		if(success){
			// 获取properties的属性。
			Properties prop = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("path.properties");
			try {
				prop.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 获取真实物理路径
			String downloadUrl = prop.getProperty("downloadUrl").trim();
			
			this.appid = strategy.getAppid();
			this.url = downloadUrl+strategy.getUrl();
			this.versionCode = strategy.getVersionCode();
			this.updateMessage = strategy.getChangelog();
		}else{
			this.appid = "";
			this.url = "";
			this.versionCode = -1; //无更新信息
			this.updateMessage = "";
		}
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public int getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}

	public String getUpdateMessage() {
		return updateMessage;
	}

	public void setUpdateMessage(String updateMessage) {
		this.updateMessage = updateMessage;
	}

	@Override
	public String toString() {
		return "UpdateMassege [appid=" + appid + ", url=" + url + ", versionCode=" + versionCode + ", updateMessage="
				+ updateMessage + "]";
	}
	
	
}
