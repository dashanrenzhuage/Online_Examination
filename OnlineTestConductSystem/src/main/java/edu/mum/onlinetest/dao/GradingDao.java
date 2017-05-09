package edu.mum.onlinetest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Grading;

@Repository
public interface GradingDao extends CrudRepository<Grading, Long>{

}
