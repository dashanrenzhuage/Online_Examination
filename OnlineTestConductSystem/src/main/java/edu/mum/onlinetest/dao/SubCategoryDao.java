package edu.mum.onlinetest.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.SubCategory;


@Repository
public interface SubCategoryDao extends CrudRepository<SubCategory, Long>{

	@Query("select s from SubCategory as s where s.category.id= :id")
	List<SubCategory> getSubCategoriesByCategoryId(@Param("id") Long id);

}
