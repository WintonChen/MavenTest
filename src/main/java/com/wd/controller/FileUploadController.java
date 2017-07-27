package com.wd.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wd.model.FileModel;

@Controller
public class FileUploadController {
	
	// get log4j
	private static final Logger logger = Logger.getLogger(FileUploadController.class);

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/fileUploadPage", method = RequestMethod.GET)
	public ModelAndView fileUploadPage() {
		FileModel file = new FileModel();
		ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
		return modelAndView;
	}

	@RequestMapping(value = "/fileUploadPage", method = RequestMethod.POST)
	public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model) throws IOException {
		if (result.hasErrors()) {
			System.out.println("validation errors");
			return "fileUploadPage";
		} else {
			// 获取properties的属性。
			Properties prop = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("path.properties");
			prop.load(in);
			// 获取真实物理路径
			String realPath = prop.getProperty("realPath").trim();
			logger.info("realPath:"+realPath);
			// 获取属性
			File filePath = new File(realPath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			
//			String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
			
			
			System.out.println("Fetching file");
			MultipartFile multipartFile = file.getFile();
			
			// Now do something with file...
			FileCopyUtils.copy(file.getFile().getBytes(), new File(realPath + File.separator + file.getFile().getOriginalFilename()));
			String fileName = multipartFile.getOriginalFilename();
			model.addAttribute("fileName", fileName);
			
			logger.info(multipartFile.getOriginalFilename());
			logger.info(multipartFile.getName());
			logger.info(multipartFile.getSize());
			logger.info(multipartFile.toString());
			
			return "success";
		}
	}

}
