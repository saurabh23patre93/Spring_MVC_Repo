package com.nt.service;

import java.util.List;

import com.nt.dto.PatientDetailsInputDTO;
import com.nt.dto.PatientDetailsOutputDTO;

public interface PatientMgmtService {
	public List<PatientDetailsOutputDTO> search(PatientDetailsInputDTO idto);
}
