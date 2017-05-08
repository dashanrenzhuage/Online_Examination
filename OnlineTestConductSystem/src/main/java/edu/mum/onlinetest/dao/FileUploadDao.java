package edu.mum.onlinetest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.FileLocation;

@Repository
public interface FileUploadDao extends CrudRepository<FileLocation, Long> {

}
