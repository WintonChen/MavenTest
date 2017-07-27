package com.wd.model;

public class Strategy {
	private long strategy_id;
	private String appid;
	private String name;
	private int versionCode;
	private String versionName;
	private String time;
	private boolean force;
	private String changelog;
	private String url;
	private String states;
	private int downloads;
	
	public long getStrategy_id() {
		return strategy_id;
	}
	public void setStrategy_id(long strategy_id) {
		this.strategy_id = strategy_id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public boolean isForce() {
		return force;
	}
	public void setForce(boolean force) {
		this.force = force;
	}
	public String getChangelog() {
		return changelog;
	}
	public void setChangelog(String changelog) {
		this.changelog = changelog;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	
	
}
