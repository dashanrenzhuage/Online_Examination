package edu.mum.onlinetest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.TestQuestion;

@Repository
public interface TestQuestionDao extends CrudRepository<TestQuestion, Long> {

}
