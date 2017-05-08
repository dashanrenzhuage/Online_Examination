package edu.mum.onlinetest.dao;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Employee;


@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{
	
	@Query("select e from Employee as e where e.credential.role = 'COACH'")
	List<Employee> findCoach();
	
	@Query("select e from Employee as e where e.credential.role = 'DATAADMIN'")
	List<Employee> findDataAdmin();
	
	@Query("select e from Employee as e where e.credential.role = 'ADMIN'")
	List<Employee> findAdmin();
	
	
	

}
