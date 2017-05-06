package edu.mum.onlinetest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Test;

@Repository
public interface TestDao extends CrudRepository<Test, Long>{

}
