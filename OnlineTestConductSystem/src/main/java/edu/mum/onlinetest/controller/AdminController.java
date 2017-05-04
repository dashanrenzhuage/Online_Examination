package edu.mum.onlinetest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.onlinetest.model.Credential;
import edu.mum.onlinetest.model.Employee;
import edu.mum.onlinetest.service.EmployeeServiceInterface;

@Controller
@RequestMapping("/employee")
public class AdminController {
	@Autowired
	EmployeeServiceInterface employeeService;

	// Get all employee----
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
		public List<Employee> getALl(Model model){
		return  employeeService.getAllEmployee();
		
		
	}
	

	// Get employee by ID------
	@ResponseBody
	@RequestMapping("/{id}")
	public Employee getEmployeeById(Model model, @PathVariable("id") Long id) {
		
		return employeeService.getEmployeeByID(id);
	}
	
	// Add employee
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addVehicle(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		
		if(result.hasErrors()){
			return "employee/admin/employess";
		}
		employeeService.saveEmployee(employee);
		return "employeeHomepage";
	}
	
	// Delete employee of particular id
	@RequestMapping("/delete/{id}")
	public String removePerson(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeByID(id);
		
		return "employeeHomepage";
	}
	
	
	
}
