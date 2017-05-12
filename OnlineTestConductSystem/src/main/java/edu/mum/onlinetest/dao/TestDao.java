package edu.mum.onlinetest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.Test;

@Repository
public interface TestDao extends CrudRepository<Test, Long>{
	
	@Query("select q from Test as q where q.student.id = :id ")

	List<Test> findByStudentId(@Param("id") Long id);

}
