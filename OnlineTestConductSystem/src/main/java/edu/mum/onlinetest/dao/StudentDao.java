package edu.mum.onlinetest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Long> {

	@Query("Select s from Student as s where coach.id = :id")
	List<Student> findStudentByCoachId(@Param("id") Long id);

}
