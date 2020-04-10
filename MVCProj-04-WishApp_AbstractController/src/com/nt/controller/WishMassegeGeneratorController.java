package com.nt.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMassegeGeneratorController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Calendar cal=null;
		int hour=0;
		String msg=null;
		System.out.println("WishMassegeGeneratorController.handleRequestInternal()");
		//Get System Date
		cal=Calendar.getInstance();
		//Get current day of houres
		hour=cal.get(Calendar.HOUR_OF_DAY);
		//Generate wish message
		if(hour<12)
			msg="Good Morning";
		else if(hour<16)
			msg="Good AfterNoon";
		else if(hour<20)
			msg="Good Evening";
		else 
			msg="Good Night";		
		return new ModelAndView("result","wmsg",msg);
	}

}
