package edu.mum.onlinetest.service;

import java.util.List;


import edu.mum.onlinetest.model.FileLocation;

public interface FileUploadServiceInterface {
	
	public List<FileLocation>getAllFileLocation(); 
	public FileLocation getFileLocationByID(Long id);
	public void saveFileLocation(FileLocation fileUpload);
	public void deleteFileLocationByID(Long id);


}
