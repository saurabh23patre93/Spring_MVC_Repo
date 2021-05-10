package com.nt.dao;

import java.util.List;

import com.nt.bo.PatientDetailsInputBO;
import com.nt.bo.PatientDetailsOutputBO;

public interface PatientInfoDAO {
	public List<PatientDetailsOutputBO> find(PatientDetailsInputBO ibo);
}
