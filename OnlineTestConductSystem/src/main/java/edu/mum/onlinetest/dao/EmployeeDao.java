package edu.mum.onlinetest.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlinetest.model.Employee;


@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{
	

}
