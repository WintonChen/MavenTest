package com.wd.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.log4j.Logger;

@Controller
public class FileDownloadController {

	private static final Logger logger = Logger.getLogger(FileDownloadController.class);

	@RequestMapping(value = "/fileDownloadPage", method = RequestMethod.GET)
	public String getDownloadPage() {
		return "fileDownload";
	}

	@RequestMapping(value = "/fileDownload", method = RequestMethod.GET)
	public String downloadFile(@RequestParam("fileName") String fileName, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("fileName:" + fileName);
		if (fileName != null) {

			try {
				// 获取properties的属性。
				Properties prop = new Properties();
				InputStream in = this.getClass().getClassLoader().getResourceAsStream("path.properties");
				prop.load(in);
				// 获取真实物理路径
				String realPath = prop.getProperty("realPath").trim();

				File file = new File(realPath, fileName);

				if (file.exists()) {
					// response.setContentType("application/force-download");//
					// 设置强制下载不打开
					response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
					byte[] buffer = new byte[1024];
					FileInputStream fis = null;
					BufferedInputStream bis = null;
					try {
						fis = new FileInputStream(file);
						bis = new BufferedInputStream(fis);
						OutputStream os = response.getOutputStream();
						int i = bis.read(buffer);
						while (i != -1) {
							os.write(buffer, 0, i);
							i = bis.read(buffer);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally {
						if (bis != null) {
							try {
								bis.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if (fis != null) {
							try {
								fis.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

}
