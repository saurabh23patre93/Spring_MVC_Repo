package com.nt.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileUpLoadCommand {
	private MultipartFile file1;
	private MultipartFile file2;
}
