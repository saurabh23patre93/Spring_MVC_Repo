package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dispatcher.Dispatcher;
import com.nt.handler.Handler;
import com.nt.handler.HandlerHelper;
import com.nt.handler.SystemDateHandler;
import com.nt.handler.SystemPropsHandler;

public class ControllerServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Handler handler=null;
		String lvn=null,target=null;
		RequestDispatcher rd=null;;
		
		try {
			handler=HandlerHelper.handler(req.getServletPath());
			lvn=handler.execute(req, resp);
			//view Management
			Dispatcher.render(lvn, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Forward to view components
//		rd=req.getRequestDispatcher(target);
//		rd.forward(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
