package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.PatientDetailsInputBO;
import com.nt.bo.PatientDetailsOutputBO;
import com.nt.dao.PatientInfoDAO;
import com.nt.dto.PatientDetailsInputDTO;
import com.nt.dto.PatientDetailsOutputDTO;

public class PatientMgmtServiceImpl implements PatientMgmtService {
	private PatientInfoDAO dao;
	
	public PatientMgmtServiceImpl(PatientInfoDAO dao) {
		System.out.println("PatientMgmtServiceImpl-1 Param constructor");
		this.dao = dao;
	}


	@Override
	public List<PatientDetailsOutputDTO> search(PatientDetailsInputDTO idto) {
		PatientDetailsInputBO iBO=null;
		List<PatientDetailsOutputBO> listRBO=null;
		List<PatientDetailsOutputDTO> listRDTO=new ArrayList();
		//convert iDTO to iBO
		iBO=new PatientDetailsInputBO();
		BeanUtils.copyProperties(idto, iBO);
		
		if(iBO.getPname().length()!=0)
			iBO.setPname(iBO.getPname()+"%");
		iBO.setPaddrs(iBO.getPaddrs().length()!=0?iBO.getPaddrs()+"%":iBO.getPaddrs());
		iBO.setDoctor(iBO.getDoctor().length()!=0?iBO.getDoctor()+"%":iBO.getDoctor());
		iBO.setProblem(iBO.getProblem().length()!=0?iBO.getProblem()+"%":iBO.getProblem());
		//use DAO
		listRBO=dao.find(iBO);
		//convert listRBO to listRDTO
		listRBO.forEach(bo->{
			PatientDetailsOutputDTO dto=new PatientDetailsOutputDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listRDTO.size()+1);
			listRDTO.add(dto);
		});
		return listRDTO;
	}

}
