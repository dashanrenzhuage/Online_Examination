package edu.mum.onlinetest.dao;

import org.springframework.data.repository.CrudRepository;

import edu.mum.onlinetest.model.Report;

public interface ReportDao extends CrudRepository<Report, Long>{

}
