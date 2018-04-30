package com.corestone.home;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HandController {
	
	private static final Logger logger = LoggerFactory.getLogger(HandController.class);
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/main");
		
		return mv;
	}
	
}
