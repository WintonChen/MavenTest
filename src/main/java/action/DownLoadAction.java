package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


import org.apache.struts2.convention.annotation.Result;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;


//下载文件；返回的文件名，不支持中文
@Result(
		  name = "success", 
		    type = "stream", 
		    params = { 
		        "contentType", "${type}", 
		        "inputName", "${fileInputStream}", 
		        "bufferSize", "1024", 
		        "contentDisposition", "attachment;filename=\"${fileName}\""
		    }
)


public class DownLoadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1504706904040842415L;

	private String type = "application/octet-stream";
	
	
	public String getType() {
		return type;
	}

	private String fileName;
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}



	private InputStream fileInputStream;

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	// get log4j
    private static final Logger logger = Logger.getLogger(DownLoadAction.class);

	
	public String execute() throws Exception {

		// 获取properties的属性。
		Properties prop = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("path.properties");
		prop.load(in);
		// 获取真实物理路径
		String realPath = prop.getProperty("realPath").trim();
		logger.info("realPath:" + realPath);
		logger.info("fileName:"+fileName);
		fileInputStream = new FileInputStream(new File(realPath+File.separator+fileName));
		return SUCCESS;
	}

}
