package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HelloController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}
	
	@RequestMapping(value = "/helloview", method = RequestMethod.GET)
	public String printHelloView(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework! helloview ");
		return "hello";
	}
}
