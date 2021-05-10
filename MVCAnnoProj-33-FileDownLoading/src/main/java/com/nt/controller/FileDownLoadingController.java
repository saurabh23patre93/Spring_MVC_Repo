package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.DownloadFileMgmtService;

@Controller
public class FileDownLoadingController {
	@Autowired
	private DownloadFileMgmtService service;
	
	@RequestMapping("/home.htm")
	public String showHomePage() {
		System.out.println("FileDownLoadingController.showHomePage()");
		return "welcome";
	}
	@RequestMapping("/list_files.htm")
	public String listFiles(Map<String, Object>map,
						HttpServletRequest req) {
		List<String> listOfFiles=null;
		String uploadStore=null;
		ServletContext sc=null;
		System.out.println("FileDownLoadingController.listFiles()");
		
		//Get servlet context
		sc=req.getServletContext();
		//Get request param value
		uploadStore=sc.getInitParameter("UPLOAD_STORE");
		//Use of service
		listOfFiles=service.getAllFiles(uploadStore);
		//Keep all files in model attribute
		map.put("fileList",listOfFiles);
		//Return lvn
		return "download_files";
	}
	@RequestMapping("/download_files.htm")
	public String downloadFiles(@RequestParam("fname")String fileName,
							HttpServletRequest req,
							HttpServletResponse resp)throws Exception{
		ServletContext sc=null;
		String uploadstore=null;
		File file=null;
		InputStream io1=null,io2=null;
		OutputStream os1=null;
		
		//Get ServletContext object
		sc=req.getServletContext();
		//Get Uploaded file location
		uploadstore=sc.getInitParameter("UPLOAD_STORE");
		//Create file object file to download
		file=new File(uploadstore+"/"+fileName);
		//Get length of file and make its to response object
		resp.setContentLengthLong(file.length());
		//Get file MIME type & make its response MIME type
		resp.setContentType(sc.getMimeType(uploadstore+"/"+fileName));
		//Create input stream pointing to file
		io1=new FileInputStream(file);
		//Create output stream pointing to response object
		os1=resp.getOutputStream();
		//Give instruction to browser to make the received output is downloadable file
		resp.setHeader("Content-Disposition","attachment:fileName="+fileName);
		//Copy the content from file to response
		IOUtils.copy(io1, os1);
		//Close stream
		io1.close();
		os1.close();
		return null;
	}
}
