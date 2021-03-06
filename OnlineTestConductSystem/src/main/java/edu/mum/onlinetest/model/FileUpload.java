package edu.mum.onlinetest.model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FileUpload {
	@JsonIgnore 
	private MultipartFile uploadFile;
	
	private Long subCateroryId;
	

	public Long getSubCateroryId() {
		return subCateroryId;
	}

	public void setSubCateroryId(Long subCateroryId) {
		this.subCateroryId = subCateroryId;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	
	
	
}
