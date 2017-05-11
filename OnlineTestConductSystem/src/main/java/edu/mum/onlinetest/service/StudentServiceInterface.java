package edu.mum.onlinetest.service;

import java.util.List;


import edu.mum.onlinetest.model.Student;

public interface StudentServiceInterface {
	public List<Student>getAllStudent(); 
	public Student getStudentByID(Long id);
	public void saveStudent(Student student);
	public void deleteStudentByID(Long id);
	public int countTotalStudent();
	public List<Student> findStudentByCoachId(Long id);
}
