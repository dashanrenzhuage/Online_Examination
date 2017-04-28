package edu.mum.onlinetest.service;

import java.util.List;


import edu.mum.onlinetest.model.Employee;


public interface EmployeeServiceInterface {
	public List<Employee>getAllEmployee(); 
	public Employee getEmployeeByID(Long id);
	public void saveEmployee(Employee employee);
	public void deleteEmployeeByID(Long id);

}
