package com.nt.handler;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemDateHandler implements Handler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		Date sysdate=null;
		
		//Write b-logic
		sysdate=new Date();
		//Keep in response scope
		req.setAttribute("result",sysdate);
		//Return logical and view name
		return "date";
	}

}
