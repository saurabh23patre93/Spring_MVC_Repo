package com.nt.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.command.FileUpLoadCommand;

@Controller
public class FileUploadController {
	@GetMapping("/upload.htm")
	public String showForm(@ModelAttribute("uplCmd")FileUpLoadCommand cmd) {
		System.out.println("FileUploadController.showForm()");
		return "file_upload_form";
	}
	
	@PostMapping("/file_upload_form.htm")
	//@RequestMapping(value="/file_upload_form.htm")
	public String upLoadFiles(Map<String,Object> map,
							@ModelAttribute("uplCmd")FileUpLoadCommand cmd,
							HttpServletRequest req)throws Exception{
		System.out.println("FileUploadController.upLoadFiles()");
		ServletContext sc=null;
		String UPLOAD_PATH=null,fileName1=null,fileName2=null;
		InputStream IS1=null,IS2=null;
		OutputStream OS1=null,OS2=null;
		
		//Read Context param values of location to store the file
		sc=req.getServletContext();
		UPLOAD_PATH=sc.getInitParameter("UPLOAD_STORE");
		//Get uploaded file names
		fileName1=cmd.getFile1().getOriginalFilename();
		fileName2=cmd.getFile2().getOriginalFilename();
		//Create Input Stream representing uploaded files content
		IS1=cmd.getFile1().getInputStream();
		IS2=cmd.getFile2().getInputStream();
		//Create Output Stream pointing to destination file
		OS1=new FileOutputStream(UPLOAD_PATH+"/"+fileName1);
		OS2=new FileOutputStream(UPLOAD_PATH+"/"+fileName2);
		//Copy the output file content to destination files
		IOUtils.copy(IS1,OS1);
		IOUtils.copy(IS2, OS2);
		//Keep uploaded file names as modelattrubute
				map.put("fileName1", fileName1);
				map.put("fileName2",fileName2);
		//Closed the stream
		IS1.close();
		IS2.close();
		OS1.close();
		OS2.close();
		
		//Return lvn
		return "upload_success";
	}
}
