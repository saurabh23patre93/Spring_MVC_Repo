package com.nt.dispatcher;

import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher {
	private static ResourceBundle bundle;
	static {
		try {
			//Locate config properties
			bundle=ResourceBundle.getBundle("com.nt.config.AppConfig.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void render(String lvn,HttpServletRequest req,HttpServletResponse resp)throws Exception{
		String physicalView=null;
		RequestDispatcher rd=null;
		
		//Get physical view name based on given logical name
		physicalView=bundle.getString(lvn);
		//Forward to physical view
		rd=req.getRequestDispatcher(physicalView);
		rd.forward(req, resp);
	}
}
