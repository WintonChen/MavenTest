package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wd.model.FileModel;

@Controller
public class FileDownloadController {

	@RequestMapping(value = "/fileDownloadPage", method = RequestMethod.GET)
	public String fileDownloadPage() {
		return "fileDownload";
	}
	
//	public fileDownload
	
}
