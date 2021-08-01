package com.isell.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView LoginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		  
		return model;
	}
	
	@RequestMapping(value= {"/home"}, method=RequestMethod.POST)
	 public ModelAndView home() {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("home");
	  return model;
	 }
	
	@RequestMapping(value= {"/logout"}, method=RequestMethod.GET)
	 public ModelAndView accessDenied() {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("login");
	  return model;
	 }
	
	
}
