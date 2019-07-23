package com.bridgeit.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.springmvc.dao.UserDao;
import com.bridgeit.springmvc.dto.Userdto;
import com.bridgeit.springmvc.model.User;
import com.bridgeit.springmvc.service.IuserService;

@Controller
public class RegistrationController {
//	  @Autowired
//	  private UserDao dao;
	
	@Autowired
	private IuserService userservice;

	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new Userdto());
	    
	    return mav;
	  }
	  
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") Userdto user) {
		  userservice.register(user);
	  return new ModelAndView("welcome", "firstname", user.getFirstname());
	  }
}
