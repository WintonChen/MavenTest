package action;

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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(appid);
		return super.execute();
	}
	
//	
	
	
}
