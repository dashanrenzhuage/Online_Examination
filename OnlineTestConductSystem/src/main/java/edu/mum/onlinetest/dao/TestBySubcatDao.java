package edu.mum.onlinetest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.TestBySubCategory;
import edu.mum.onlinetest.model.TestQuestion;

@Repository
public interface TestBySubcatDao extends CrudRepository<TestBySubCategory, Long>{
	

}
