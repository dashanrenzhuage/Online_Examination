package edu.mum.onlinetest.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.SubCategory;


@Repository
public interface SubCategoryDao extends CrudRepository<SubCategory, Long>{
	
	
	@Query("select s from SubCategory as s  where s.flag = true and s.category.flag = true")
	 List<SubCategory> getAllSubCategory();
	
	@Query("select s from SubCategory as s  where s.category = :category")
	List<SubCategory> getSubcategoryByCategory(@Param("category") Category category);
	
	@Query("select q from SubCategory as q where q.category.id = :id ")
    List<SubCategory> findBySubCategoryFromCategory(@Param("id") Long id);
}
