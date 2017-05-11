package edu.mum.onlinetest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.AnswerSheet;
import edu.mum.onlinetest.model.Question;

@Repository
public interface AnswerSheetDao extends CrudRepository<AnswerSheet, Long> {


}
