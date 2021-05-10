package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.PatientDetailsInfoCommand;
import com.nt.dto.PatientDetailsInputDTO;
import com.nt.dto.PatientDetailsOutputDTO;
import com.nt.service.PatientMgmtService;

public class PatientInfoSearchController extends AbstractCommandController {
	private PatientMgmtService service;
	
	
	public PatientInfoSearchController(PatientMgmtService service) {
		System.out.println("PatientInfoSearchController-1 Param Constructor");
		this.service = service;
	}

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object command, BindException errors)
			throws Exception {
		PatientDetailsInfoCommand cmd=null;
		PatientDetailsInputDTO idto=null;
		List<PatientDetailsOutputDTO> listRDTO=null;
		//type castating
		cmd=(PatientDetailsInfoCommand)command;
		//convert cmd to dto
		idto=new PatientDetailsInputDTO();
		BeanUtils.copyProperties(cmd, idto);
		//use service
		listRDTO=service.search(idto);
		//return mav object
		return new ModelAndView("show_results","listRDTO",listRDTO);	}

}
