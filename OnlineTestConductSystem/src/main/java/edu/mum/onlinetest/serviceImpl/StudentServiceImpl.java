package edu.mum.onlinetest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.StudentDao;
import edu.mum.onlinetest.model.Student;
import edu.mum.onlinetest.service.StudentServiceInterface;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

	@Autowired
	StudentDao dao;

	public List<Student> getAllStudent() {
		return (List<Student>) dao.findAll();
	}

	public Student getStudentByID(Long id) {
		return dao.findOne(id);
	}

	public void deleteStudentByID(Long id) {
		dao.delete(id);

	}

	public void saveStudent(Student student) {
		dao.save(student);

	}

	public int countTotalStudent() {
		return (int) (dao.count());
	}

	@Override
	public List<Student> findStudentByCoachId(Long id) {
		// TODO Auto-generated method stub
		return dao.findStudentByCoachId(id);
	}

}
