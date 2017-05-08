package edu.mum.onlinetest.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.SubCategory;

@Repository
public interface QuestionDao extends CrudRepository<Question, Long> {

	
	/*@Query("select s from SubCategory as s  where s.category = :category")
	List<SubCategory> getSubcategoryByCategory(@Param("category") Category category);*/
	@Query("select q from Question as q where q.subCategory.subCatName = :name and q.subCategory.flag= true ")
	
	    List<Question> findBySubCategoryName(@Param("name") String name);
	
	@Query("select q.id from Question as q where q.subCategory.subCatName = :name")
	List<Long> findIdByName(@Param("name") String name);
	

}
