package com.wd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * ControllerClassNameHandlerMapping类是基于约定的处理程序映射类，
 * 它将URL请求映射到配置中提到的控制器的名称。这个类接受控制器名称并将其转换为带有前导“/”的小写形式。 例如HelloController映射到URL:
 * “/hello*”
 * 
 * @author chenwendong
 *
 */


public class MappingController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView model = new ModelAndView("hello");
		model.addObject("message", "Hello World! from ClassNameController");
		return model;
	}

}
