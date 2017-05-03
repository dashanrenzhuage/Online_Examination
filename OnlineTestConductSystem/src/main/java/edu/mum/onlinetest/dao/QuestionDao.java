package edu.mum.onlinetest.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Question;

@Repository
public interface QuestionDao extends CrudRepository<Question, Long> {

	@Query("select q from Question as q where q.subCategory.subCatName = :name ")
	
	    List<Question> findBySubCategoryName(@Param("name") String name);
	
	@Query("select q.id from Question as q where q.subCategory.subCatName = :name")
	List<Long> findIdByName(@Param("name") String name);
	

}
