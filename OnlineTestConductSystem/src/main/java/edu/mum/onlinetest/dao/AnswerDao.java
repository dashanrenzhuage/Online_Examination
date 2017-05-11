package edu.mum.onlinetest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Answer;
import edu.mum.onlinetest.model.TestQuestion;

@Repository
public interface AnswerDao extends CrudRepository<Answer, Long> {

}
