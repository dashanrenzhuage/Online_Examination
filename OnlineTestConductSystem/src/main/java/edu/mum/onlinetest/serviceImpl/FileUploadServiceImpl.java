package edu.mum.onlinetest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.onlinetest.dao.FileUploadDao;
import edu.mum.onlinetest.model.FileLocation;
import edu.mum.onlinetest.service.FileUploadServiceInterface;

@Repository
public class FileUploadServiceImpl implements FileUploadServiceInterface{

	
	@Autowired
	FileUploadDao dao;
	
	@Override
	public List<FileLocation> getAllFileLocation() {
		
		return (List<FileLocation>) dao.findAll();
	}

	@Override
	public FileLocation getFileLocationByID(Long id) {
		return dao.findOne(id);
	}

	@Override
	public void saveFileLocation(FileLocation fileUpload) {
		dao.save(fileUpload);
		
	}

	@Override
	public void deleteFileLocationByID(Long id) {
		dao.delete(id);
	}

}
