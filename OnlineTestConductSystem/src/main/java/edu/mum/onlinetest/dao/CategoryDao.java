package edu.mum.onlinetest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {

	@Query("select c from Category as c  where c.flag = true")
	List<Category> getAllCategory();

}
