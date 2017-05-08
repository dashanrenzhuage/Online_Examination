package edu.mum.onlinetest.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mum.onlinetest.model.Admin;
import edu.mum.onlinetest.model.Coach;
import edu.mum.onlinetest.model.Credential;
import edu.mum.onlinetest.model.Employee;
import edu.mum.onlinetest.model.Student;
import edu.mum.onlinetest.service.EmployeeServiceInterface;
import edu.mum.onlinetest.serviceImpl.CoachServiceImpl;
import edu.mum.onlinetest.serviceImpl.StudentServiceImpl;

@Controller
@RequestMapping("/employee")
public class AdminController {
	@Autowired
	EmployeeServiceInterface employeeService;
	@Autowired
	StudentServiceImpl studentService;


	// Get all employee---
	@RequestMapping(method = RequestMethod.GET)
	public String getEmployees(Model model) {
	model.addAttribute("employees",employeeService.getAllEmployee());
	
	return "adminHomePage";
	}

	// Get employee by ID------

	@RequestMapping("/{id}")
	public String getEmployeeById(Model model, @PathVariable("id") Long id) {
		
		model.addAttribute("admin", employeeService.getEmployeeByID(id));
		return "employeeHomepage";
	}
	

	// Add Coach
	@RequestMapping(value = "/addCoach", method = RequestMethod.GET)
	public String showAddCoachPage() {
		return "addCoach";
	}
	
	@RequestMapping(value = "/addCoach", method = RequestMethod.POST)
	public String AddCoachPage(@ModelAttribute Coach coach,BindingResult result) {
		employeeService.saveEmployee(coach);
		/*List<Coach> coaches = employeeService.getAllEmployee();
		model.addAttribute("listOfCoach" , coaches);*/
		return "listCoach";
	}
	
	//Show list of coach
	@RequestMapping(value = "/listCoach", method = RequestMethod.GET)
	public String listCoach(Model model) {
		
		/*List<Coach> coaches = employeeService.getAllEmployee();
			model.addAttribute("listOfCoach" , coaches);*/
		return "listCoach";
	}
	
	
	// Add Admin
		@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
		public String showAddAdminPage() {
			return "addAdmin";
		}
		
		@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
		public String AddAdminPage(@ModelAttribute Admin admin,BindingResult result, Model model) {
			employeeService.saveEmployee(admin);
			/*List<Admin> admins = employeeService.getAllEmployee();
			model.addAttribute("listOfAdmin" , admins);*/
			return "listAdmin";
		}
		
		
		//Show list of admin
		@RequestMapping(value = "/listAdmin", method = RequestMethod.GET)
		public String listAdmin(Model model) {
			/*List<Admin> admins = employeeService.getAllEmployee();
			model.addAttribute("listOfAdmin" , admins);*/
			return "listAdmin";
		}
		
		// Add Student
				@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
				public String showAddStudentPage(@ModelAttribute("coach") Coach coach,Model model) {
					/*List<Coach> coaches = employeeService.getAllEmployee();
					model.addAttribute("listOfCoach" , coaches);*/
			
					return "addStudent";
				}
				
				
				
				
				@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
				public String AddStudentPage(@ModelAttribute Student student,BindingResult result, Model model) {
					studentService.saveStudent(student);
					//List<Student> listOfStudents = studentService.getAllStudent();
					List<Student> students = studentService.getAllStudent();
					model.addAttribute("listOfStudent" , students);
					return "listStudent";
				}
				
				
		//Show list of Student
				@RequestMapping(value = "/listStudent", method = RequestMethod.GET)
				public String listStudent(Model model) {
					List<Student> students = studentService.getAllStudent();
					model.addAttribute("listOfStudent" , students);
					return "listStudent";
				}
		
	
	/*@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {*/


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
		return "list_User_detail";
	}
	
	
	// Edit employee
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
public String getEditEmployeePage(@PathVariable Long id, Model model) {
		Employee currentEmployee = employeeService.getEmployeeByID(id);
		model.addAttribute(currentEmployee);
		return "addEmployee";
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.PUT)
public String editEmployee(@Valid  @ModelAttribute("employee") Employee employee, BindingResult result,@PathVariable Long id) {
		
		Employee currentEmployee = employeeService.getEmployeeByID(id);
		if(result.hasErrors()){
			return "employee/admin/employess";
		}
		
		employeeService.saveEmployee(employee);
		return "list_User_detail";
	}
	
	
	
	// Delete employee of particular id
	@RequestMapping("/delete/{id}")
	public String removePerson(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeByID(id);
		
		return "employeeHomepage";
	}
	@RequestMapping(value="/coach", method = RequestMethod.GET)
	public String getCoach(Model model) {
		
		System.out.println("+++++++++++Coach List +++++++++++++++++");
		employeeService.findCoach().forEach(c->{
			
			System.out.println(c.getfName());
		});
	
		model.addAttribute("coachList",employeeService.findCoach( ));
		return "coach_home_page";
		
		
		
	}
	
	@RequestMapping(value="/dataAdmin", method = RequestMethod.GET)
	public String getDataAdmin(Model model) {
		
		System.out.println("+++++++++++Data Admin List +++++++++++++++++");
		employeeService.findDataAdmin().forEach(da->{
			
			System.out.println(da.getfName());
		});
	
		model.addAttribute("coachList",employeeService.findDataAdmin( ));
		return "coach_home_page";
		
		
		
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String getAdmin(Model model) {
		
		System.out.println("+++++++++++Admin  List +++++++++++++++++");
		employeeService.findAdmin().forEach(a->{
			
			System.out.println(a.getfName());
		});
	
		model.addAttribute("coachList",employeeService.findAdmin( ));
		return "coach_home_page";
		
		
		
	}
	
	//List of Students for admin mode
	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public String showStudentList(Model model) {
		System.out.println("******************1inside************");
		List<Student> listOfStudents = studentService.getAllStudent();
		System.out.println("******************2inside************");
		model.addAttribute("listOfStudents", listOfStudents);
		return "list_student_detail_admin";
	}
	
}
