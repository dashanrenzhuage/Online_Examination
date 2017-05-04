package edu.mum.onlinetest.dao;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.SubCategory;


@Repository
public interface SubCategoryDao extends CrudRepository<SubCategory, Long>{
	
	
	

}
