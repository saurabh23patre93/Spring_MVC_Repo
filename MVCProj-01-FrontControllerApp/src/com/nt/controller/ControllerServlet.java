package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.handler.Handler;
import com.nt.handler.SystemDateHandler;
import com.nt.handler.SystemPropsHandler;

public class ControllerServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Handler handler=null;
		String lvn=null,target=null;
		RequestDispatcher rd=null;;
		
		//Action Management
		if (req.getServletPath().equalsIgnoreCase("/date.do")) {
			handler=new SystemDateHandler();
		}else if (req.getServletPath().equalsIgnoreCase("/props.do")) {
			handler=new SystemPropsHandler();
		}else {
			throw new IllegalArgumentException("Request is not valid");
		}
		//View management
		lvn=handler.execute(req, resp);
		if (lvn.equalsIgnoreCase("date")) {
			target="/show_date.jsp";
		}else if (lvn.equalsIgnoreCase("props")) {
			target="/show_props.jsp";
		}else {
			throw new IllegalArgumentException("Invalid logical name response");
		}
		//Forward to view components
		rd=req.getRequestDispatcher(target);
		rd.forward(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
