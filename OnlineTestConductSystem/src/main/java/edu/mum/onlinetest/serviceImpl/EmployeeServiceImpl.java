package edu.mum.onlinetest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.onlinetest.dao.EmployeeDao;
import edu.mum.onlinetest.model.Employee;
import edu.mum.onlinetest.service.EmployeeServiceInterface;

@Service

public class EmployeeServiceImpl implements EmployeeServiceInterface{
	
	@Autowired
	EmployeeDao dao;

	public List<Employee> getAllEmployee() {
		return (List<Employee>) dao.findAll();
	}

	public Employee getEmployeeByID(Long id) {
		return dao.findOne(id);
	}

	

	public void deleteEmployeeByID(Long id) {
		dao.delete(id);
		
	}

	public void saveEmployee(Employee employee) {
		dao.save(employee);
		
	}

}
