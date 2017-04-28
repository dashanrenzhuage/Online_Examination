package edu.mum.onlinetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.onlinetest.model.Credential;
import edu.mum.onlinetest.model.Employee;
import edu.mum.onlinetest.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/employee/admin")
public class AdminController {
	@Autowired
	EmployeeServiceInterface employeeService;

	// Get all employee----
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAll() {
		System.out.println("at employee >>>> admin");
		/* LOG.info("getting all employees"); */
		List<Employee> employees = employeeService.getAllEmployee();

		/*
		 * if (employees == null || employees.isEmpty()){
		 * LOG.info("no employee found"); return new
		 * ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT); }
		 */

		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	// Get employee by ID------

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> get(@PathVariable("id") Long id) {

		Employee employee = employeeService.getEmployeeByID(id);

		/*
		 * if (user == null){ LOG.info("Employee with id {} not found", id);
		 * return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND); }
		 */

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	// Add employee ------

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
		employeeService.saveEmployee(employee);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Update existing employee-----

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
		// LOG.info("updating employee: {}", employee);
		Employee currentEmployee = employeeService.getEmployeeByID(id);

		/*
		 * if (currentEmployee == null){
		 * LOG.info("Employee with id {} not found", id); return new
		 * ResponseEntity<Category>(HttpStatus.NOT_FOUND); }
		 */
		currentEmployee.setId(employee.getId());
		Credential credential = new Credential();
		credential.setPassword(employee.getCredential().getPassword());
		credential.setUsername(employee.getCredential().getUsername());
		credential.setEnabled(employee.getCredential().isEnabled());
		currentEmployee.setCredential(credential);

		employeeService.saveEmployee(currentEmployee);
		return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
	}

	// Delete employee -----

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		// LOG.info("deleting employee with id: {}", id);
		Employee employee = employeeService.getEmployeeByID(id);

		if (employee == null) {
			// LOG.info("Unable to delete. Employee with id {} not found", id);

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		employeeService.deleteEmployeeByID(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
