package edu.mum.onlinetest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "adminHomePage";
	}

	// Get employee by ID------

	@RequestMapping("/{id}")
	public String getEmployeeById(Model model, @PathVariable("id") Long id) {
		model.addAttribute("admin", employeeService.getEmployeeByID(id));
		return "employeeHomepage";
	}

	// Add Coach
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String signUp(@ModelAttribute("newAdmin") Employee employee) {
		return "addCoach";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addVehicle(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			/*return "signUp";*/
			return "addCoach";
		}
		employeeService.saveEmployee(employee);
		/*return "adminHomePage";*/
		model.addAttribute("coachList", employeeService.findCoach());
		return "listCoach";
	}

	// Add Admin
	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
	public String signUp1(@ModelAttribute("newAdmin") Employee employee) {
		return "addAdmin";
	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String addVehicle12(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			/*return "signUp";*/
			return "addAdmin";
		}
		employeeService.saveEmployee(employee);
		/*return "adminHomePage";*/
		model.addAttribute("adminList", employeeService.findAdmin());
		return "listAdmin";
	}

	// Add Data Admin
	@RequestMapping(value = "/addDataAdmin", method = RequestMethod.GET)
	public String signUp2(@ModelAttribute("newDataAdmin") Employee employee) {
		return "addDataAdmin";
	}

	@RequestMapping(value = "/addDataAdmin", method = RequestMethod.POST)
	public String addVehicle13(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			/*return "signUp";*/
			return "addDataAdmin";
		}
		employeeService.saveEmployee(employee);
		/*return "adminHomePage";*/
		model.addAttribute("dataAdminList", employeeService.findDataAdmin());
		return "listDataAdmin";

	}

	// Show list of coach
	@RequestMapping(value = "/listCoach", method = RequestMethod.GET)
	public String listCoach(Model model) {

		employeeService.findCoach().forEach(c -> {

			System.out.println(c.getfName());
		});
		System.out.println(employeeService.findCoach());
		model.addAttribute("coachList", employeeService.findCoach());
		return "listCoach";
	}

	@RequestMapping(value = "/listAdmin", method = RequestMethod.GET)
	public String listAdmin(Model model) {

		employeeService.findAdmin().forEach(c -> {

			System.out.println(c.getfName());
		});
		System.out.println(employeeService.findAdmin());
		model.addAttribute("adminList", employeeService.findAdmin());
		return "listAdmin";
	}

	@RequestMapping(value = "/listDataAdmin", method = RequestMethod.GET)
	public String listDataAdmin(Model model) {

		employeeService.findDataAdmin().forEach(c -> {

			System.out.println(c.getfName());
		});
		System.out.println(employeeService.findDataAdmin());
		model.addAttribute("dataAdminList", employeeService.findDataAdmin());
		return "listDataAdmin";
	}

	// Edit employee
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String getEditEmployeePage(@PathVariable Long id, Model model) {

		Employee employee = employeeService.getEmployeeByID(id);
		model.addAttribute(employee);
		/*
		 * Employee newAdmin = employeeService.getEmployeeByID(id);
		 * model.addAttribute(newAdmin);
		 * System.out.println("************************ edit");
		 * System.out.println(newAdmin);
		 */
		return "editCoach";
	}

	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public String editEmployee(@Valid @ModelAttribute("employee") Employee employee1, BindingResult result,
			@PathVariable Long id, Model model) {
		if (result.hasErrors()) {
			Employee employee = employeeService.getEmployeeByID(id);
			model.addAttribute(employee);
			return "editCoach";
		}
		Employee currentEmployee = employeeService.getEmployeeByID(id);
		
		employeeService.saveEmployee(employee1);
		return "listCoach";
	}

	@RequestMapping(value = "/addAdmin/{id}", method = RequestMethod.GET)
	public String getEditEmployeePage1(@PathVariable Long id, Model model) {

		Employee employee = employeeService.getEmployeeByID(id);
		model.addAttribute(employee);
		/*
		 * Employee newAdmin = employeeService.getEmployeeByID(id);
		 * model.addAttribute(newAdmin);
		 * System.out.println("************************ edit");
		 * System.out.println(newAdmin);
		 */
		return "editAdmin";
	}

	@RequestMapping(value = "/addAdmin/{id}", method = RequestMethod.POST)
	public String editEmployee1(@Valid @ModelAttribute("employee") Employee employee1, BindingResult result,
			@PathVariable Long id, Model model) {
		if (result.hasErrors()) {
			Employee employee = employeeService.getEmployeeByID(id);
			model.addAttribute(employee);
			return "editAdmin";
		}
		//Employee currentEmployee = employeeService.getEmployeeByID(id);
		employeeService.saveEmployee(employee1);
		return "listAdmin";
	}

	@RequestMapping(value = "/addDataAdmin/{id}", method = RequestMethod.GET)
	public String getEditEmployeePage2(@PathVariable Long id, Model model) {

		System.out.println("************************66666666666666666666666666");
		Employee employee = employeeService.getEmployeeByID(id);
		model.addAttribute(employee);
		/*
		 * Employee newAdmin = employeeService.getEmployeeByID(id);
		 * model.addAttribute(newAdmin);
		 * System.out.println("************************ edit");
		 * System.out.println(newAdmin);
		 */
		return "editDataAdmin";
	}

	@RequestMapping(value = "/addDataAdmin/{id}", method = RequestMethod.POST)
	public String editEmployee2(@Valid @ModelAttribute("employee") Employee employee1, BindingResult result,
			@PathVariable Long id, Model model) {
		if (result.hasErrors()) {
			Employee employee = employeeService.getEmployeeByID(id);
			model.addAttribute(employee);
			return "editDataAdmin";
		}
		//Employee currentEmployee = employeeService.getEmployeeByID(id);
		
		employeeService.saveEmployee(employee1);
		return "listDataAdmin";
	}
	
	/*@RequestMapping(value = "/addAdmin/{id}", method = RequestMethod.GET)
	public String getEditEmployeePage1(@PathVariable Long id, Model model) {
		
		System.out.println("************************66666666666666666666666666");
		Employee employee = employeeService.getEmployeeByID(id);
		model.addAttribute(employee);
		
		 * Employee newAdmin = employeeService.getEmployeeByID(id);
		 * model.addAttribute(newAdmin);
		 * System.out.println("************************ edit");
		 * System.out.println(newAdmin);
		 
		return "editAdmin";
	}*/

	/*@RequestMapping(value = "/addAdmin/{id}", method = RequestMethod.POST)
	public String editEmployee1(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			@PathVariable Long id) {

		Employee currentEmployee = employeeService.getEmployeeByID(id);
		if (result.hasErrors()) {
			return "employee/admin/employess";
		}
		employeeService.saveEmployee(employee);
		return "adminHomePage";
	}*/

	// Delete employee of particular id
	@RequestMapping(value = "/deleteCoach/{id}")
	public String removePerson(@PathVariable("id") Long id, RedirectAttributes rm, Model model) {
		rm.addFlashAttribute("coachDeleteMessage", "Coach has been successfully deleted!");
		employeeService.deleteEmployeeByID(id);
		model.addAttribute("coachList", employeeService.findCoach());
		return "listCoach";
	}
	@RequestMapping("/deleteAdmin/{id}")
	public String removePerson1(@PathVariable("id") Long id, RedirectAttributes rm, Model model) {
		rm.addFlashAttribute("adminDeleteMessage", "Administrator has been successfully deleted!");
		employeeService.deleteEmployeeByID(id);
		model.addAttribute("adminList", employeeService.findAdmin());
		return "listAdmin";
	}
	@RequestMapping("/deleteDataAdmin/{id}")
	public String removePerson2(@PathVariable("id") Long id, RedirectAttributes rm, Model model) {
		rm.addFlashAttribute("dataAdminDeleteMessage", "Data admin has been successfully deleted!");
		employeeService.deleteEmployeeByID(id);
		model.addAttribute("dataAdminList", employeeService.findDataAdmin());
		return "listDataAdmin";
	}

	// users with role coach
	@RequestMapping(value = "/coach", method = RequestMethod.GET)
	public String getCoach(Model model) {

		System.out.println("+++++++++++Coach List +++++++++++++++++");
		employeeService.findCoach().forEach(c -> {
			System.out.println(c.getfName());
		});
		model.addAttribute("coachList", employeeService.findCoach());
		return "coach_home_page";

	}

	// users with role coach
	@RequestMapping(value = "/dataAdmin", method = RequestMethod.GET)
	public String getDataAdmin(Model model) {

		System.out.println("+++++++++++Data Admin List +++++++++++++++++");
		employeeService.findDataAdmin().forEach(da -> {
			System.out.println(da.getfName());
		});
		model.addAttribute("coachList", employeeService.findDataAdmin());
		return "coach_home_page";

	}

	// users with role coach
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdmin(Model model) {
		System.out.println("+++++++++++Admin  List +++++++++++++++++");
		employeeService.findAdmin().forEach(a -> {

			System.out.println(a.getfName());
		});
		model.addAttribute("coachList", employeeService.findAdmin());
		return "coach_home_page";

	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";

	}

}