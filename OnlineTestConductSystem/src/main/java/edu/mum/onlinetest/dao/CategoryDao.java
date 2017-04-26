package edu.mum.onlinetest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {

}
