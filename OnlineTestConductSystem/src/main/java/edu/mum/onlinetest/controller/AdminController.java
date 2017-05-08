package edu.mum.onlinetest.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import edu.mum.onlinetest.model.Employee;
import edu.mum.onlinetest.service.EmployeeServiceInterface;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	EmployeeServiceInterface employeeService;

	// Get all employee----
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getEmployees(Model model) {
	model.addAttribute("employees",employeeService.getAllEmployee());
	
	return "adminHomepage";
		
		
		
	}
	

	// Get employee by ID------

	@RequestMapping("/{id}")
	public String getEmployeeById(Model model, @PathVariable("id") Long id) {
		
		model.addAttribute("admin", employeeService.getEmployeeByID(id));
		return "employeeHomepage";
	}
	
	// Add employee
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String signUp(@ModelAttribute("newAdmin") Employee employee){
		return "signUp";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addVehicle(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		
		if(result.hasErrors()){
			return "signUp";
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
