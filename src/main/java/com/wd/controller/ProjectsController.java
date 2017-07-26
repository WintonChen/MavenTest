package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.wd.model.Projects;


@Controller
public class ProjectsController {
	 @RequestMapping(value = "/projects", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("projects", "command", new Projects());
	   }

	   @RequestMapping(value = "/addProjects", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")Projects projects, 
	   ModelMap model) {
	    
	      return "result";
	   }
}
