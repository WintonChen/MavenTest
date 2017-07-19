package action;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4311773232805645652L;

	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	// get log4j
	private static final Logger logger = Logger.getLogger(UpdateAction.class);

	public String execute() throws Exception {
		logger.info("FileUploadAction");

		logger.info("fileUploadFileName:"+fileUploadFileName);
		logger.info("fileUploadContentType:"+fileUploadContentType);
		
		
		// 获取properties的属性。
		Properties prop = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("path.properties");
		prop.load(in);
		// 获取真实物理路径
		String realPath = prop.getProperty("realPath").trim();

		// 获取属性
		File file = new File(realPath);
		if (!file.exists())
			file.mkdirs();
		// new File(imgRealPath,this.uploadImageFileName) 意思是在前边的目录下创建后边的文件
		// 下边意思是复制文件，把前边的文件复制到后边的文件中
		FileUtils.copyFile(fileUpload, new File(realPath, this.fileUploadFileName));

		return SUCCESS;

	}

	public String display() {
		return NONE;
	}
}
