package com.nt.handler;

import java.util.ResourceBundle;

public class HandlerHelper {
	private static ResourceBundle bundle;
	static {
		try {
			//Locate config properties
			bundle=ResourceBundle.getBundle(("com/nt/config/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Handler handler(String url) throws Exception{
		String handlerName=null;
		Handler handler=null;
		
		//Get handler class name
		handlerName=bundle.getString(url);
		//Create Handler class object
		handler=(Handler) Class.forName(handlerName).newInstance();
		return handler;
	}
}
