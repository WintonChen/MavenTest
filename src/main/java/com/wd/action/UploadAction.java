package com.wd.action;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1826854740015330482L;
	
	private File uploadFile;
	private String contentType;
	private String filename;

	public void setUpload(File file) {
		this.uploadFile = file;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}

	
	
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}




	// get log4j
	private static final Logger logger = Logger.getLogger(UploadAction.class);

	public String execute() throws Exception{
		// ...

		logger.info("UploadAction");

		logger.info("filename:" + filename);
		logger.info("contentType:" + contentType);

		// 获取properties的属性。
		Properties prop = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("path.properties");
		prop.load(in);
		// 获取真实物理路径
		String realPath = prop.getProperty("realPath").trim();
		logger.info("realPath:"+realPath);
		// 获取属性
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		// new File(imgRealPath,this.uploadImageFileName) 意思是在前边的目录下创建后边的文件
		// 下边意思是复制文件，把前边的文件复制到后边的文件中
		FileUtils.copyFile(uploadFile, new File(realPath, this.filename));

		return SUCCESS;
	}
}
