package com.nt.bo;

import lombok.Data;

@Data
public class PatientDetailsOutputBO extends PatientDetailsInputBO {
	private int pid;
	private int wardNo;
	private long contactNo;
    private  int age;
}
