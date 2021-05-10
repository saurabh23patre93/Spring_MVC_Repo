package com.nt.dto;

import lombok.Data;

@Data
public class PatientDetailsOutputDTO extends PatientDetailsInputDTO {
	private int srNo;
	private int pid;
	private int wardNo;
	private long contactNo;
    private  int age;
}
