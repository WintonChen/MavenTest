package com.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

	@ModelAttribute("projects")
	public Projects createProjectsModel() {
		return new Projects();
	}

	@RequestMapping(value = "/addProjects", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("projects") @Validated  Projects projects, 
			BindingResult bindingResult,
			ModelMap model) {

		// 表单 验证 @Validated
		if (bindingResult.hasErrors()) {
			return "projects";
		}

		model.addAttribute("appid", projects.getAppid());
		model.addAttribute("name", projects.getName());
		model.addAttribute("icon", projects.getIcon());
		model.addAttribute("platform", projects.getPlatform());
		model.addAttribute("type", projects.getType());
		model.addAttribute("info", projects.getInfo());
		model.addAttribute("time", projects.getTime());
		model.addAttribute("creator", projects.getCreator());

		return "result";
	}
}
