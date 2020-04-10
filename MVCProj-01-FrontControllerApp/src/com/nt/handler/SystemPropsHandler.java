package com.nt.handler;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemPropsHandler implements Handler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		Properties props=null;
		
		//Write b logic
		props=System.getProperties();
		//Keep in response
		req.setAttribute("result",props);
		return "props";
	}

}
