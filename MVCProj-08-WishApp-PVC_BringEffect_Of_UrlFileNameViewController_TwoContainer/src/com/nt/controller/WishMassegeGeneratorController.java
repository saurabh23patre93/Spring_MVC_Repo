package com.nt.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMessageService;

public class WishMassegeGeneratorController extends AbstractController {
	private WishMessageService service;
	
	public WishMassegeGeneratorController(WishMessageService service) {
		System.out.println("WishMassegeGeneratorController-1 Param constructor");
		this.service=service;
	}
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("WishMassegeGeneratorController.handleRequestInternal()");
		String msg=null;
		
		//Use service
		msg=service.generateWishMessage();
		return new ModelAndView("result", "wmsg", msg);
	}
}
