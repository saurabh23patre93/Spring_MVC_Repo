package com.nt.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMessageService;

@Controller
public class WishMessageGeneratorController  {
	@Autowired
	private WishMessageService service;
	@RequestMapping("/wish.htm")
	public   ModelAndView  process() {
		String msg=null;
		//use service
		msg=service.generateWishMessage();
		//return MAV
		return new ModelAndView("result","wmsg", msg);
		
	}
}
