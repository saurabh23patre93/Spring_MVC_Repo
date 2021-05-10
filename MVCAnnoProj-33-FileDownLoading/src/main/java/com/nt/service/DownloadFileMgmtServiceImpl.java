package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("dfmService")
public class DownloadFileMgmtServiceImpl implements DownloadFileMgmtService {

	@Override
	public List<String> getAllFiles(String uploadStore) {
		File fileStore=null;
		List<String> listOfFiles=null;
		File files[]=null;
		
		//System.out.println("DownloadFileMgmtServiceImpl.getAllFiles()");
		//Locate upload store using java.io.file class
		fileStore=new File(uploadStore);
		if (fileStore.exists()) {
			System.out.println("DownloadFileMgmtServiceImpl.getAllFiles()-ifcondition");
			listOfFiles=new ArrayList();
			 files=fileStore.listFiles();
		
		for (File f :files) {
			System.out.println("DownloadFileMgmtServiceImpl.getAllFiles()-forloop2");
			if (!f.isDirectory())
				System.out.println("DownloadFileMgmtServiceImpl.getAllFiles()-if conditon");
			listOfFiles.add(f.getName());
		}
		}
		return listOfFiles;
	}

}
