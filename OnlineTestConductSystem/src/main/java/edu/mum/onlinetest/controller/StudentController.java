package edu.mum.onlinetest.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.Employee;
import edu.mum.onlinetest.model.Student;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.CategoryServiceInterface;
import edu.mum.onlinetest.service.EmployeeServiceInterface;
import edu.mum.onlinetest.service.StudentServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;
import edu.mum.onlinetest.serviceImpl.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentServiceInterface studentService;

	@Autowired
	CategoryServiceInterface categoryService;

	@Autowired
	SubCategoryInterface subCategoryService;

	@Autowired
	StudentServiceImpl studentServiceImpl;
	@Autowired
	EmployeeServiceInterface employeeService;

	@RequestMapping(value = "/studentExamLogin", method = RequestMethod.GET)
	public String studentExamLogin() {
		return "stu_login";
	}

	@RequestMapping(value = "/studentExamSelection", method = RequestMethod.POST)
	public String studentCategorySubCategorySection(
			/* @PathVariable("id") Long id */ HttpServletRequest request, Model model) {
		List<Student> students = studentServiceImpl.getAllStudent();

		System.out.println(request.getParameter("accessCode"));

		for (int i = 0; i < students.size(); i++) {
			String accessID = students.get(i).getAccessCode();
			Student student = students.get(i);

			if (accessID != null) {

				if (accessID.equals((String) request.getParameter("accessCode"))) {
					List<Category> listOfCategories = categoryService.getAllCategory();
					List<SubCategory> listOfSubCategories = subCategoryService.getAllSubCategory();
					model.addAttribute("listOfCategories", listOfCategories);
					model.addAttribute("listOfSubcategories", listOfSubCategories);
					
					// access-code delete after login
					////student.setAccessCode(null);
					
					studentService.saveStudent(student);

					return "stu_sel_exam";
				}
			}

		}
		return "stu_login";
	}

	// Add Student
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String showAddStudentPage(@ModelAttribute("newStudent") Student student, Model model) {
		model.addAttribute("coachList", employeeService.findCoach());
		System.out.println(employeeService.findCoach());
		return "addStudent";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addVehicle(@Valid @ModelAttribute("newStudent") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("coachList", employeeService.findCoach());
			return "addStudent";
		}
		studentService.saveStudent(student);

		List<Student> listOfStudents = studentService.getAllStudent();
		System.out.println("******************2inside************");
		model.addAttribute("listStudent", listOfStudents);
		return "listStudent";
	}

	// List of Student
	@RequestMapping(value = "/listStudent", method = RequestMethod.GET)
	public String showStudentList(Model model) {
		System.out.println("******************1inside************");
		List<Student> listOfStudents = studentService.getAllStudent();
		System.out.println("******************2inside************");
		model.addAttribute("listStudent", listOfStudents);
		return "listStudent";
	}

	// Coach Home Page
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("listOfStudents", studentService.getAllStudent());
		return "coach_home_page";
	}

	// Get student by ID------

	/*@RequestMapping(value = "/testEdit", method = RequestMethod.POST)
	public String edit(@PathVariable("id") Long id, Model model) {
		System.out.println("test edit called");
//		Student student = studentService.getStudentByID(id);
//		model.addAttribute("student", student);
		return "editStudent";
	}*/
	/*@Valid @ModelAttribute("newStudent") Student student, BindingResult result*/
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@Valid @ModelAttribute Student student1, BindingResult result, Model model) {
     /*
        System.out.println("test edit called" + student.getName());
        System.out.println("test edit called" + student.getId());
        System.out.println("test edit called" + student.getEmail());*/
		if(result.hasErrors()){
			Student student = studentService.getStudentByID(student1.getId());
			model.addAttribute("student", student);
			//return "editStudent";
			new ModelAndView("redirect:/students/editStudent");
		}
        studentService.saveStudent(student1);
        List<Student> listOfStudents = studentService.getAllStudent();
		model.addAttribute("listStudent", listOfStudents);

        return new ModelAndView("redirect:/students/listStudent");
    }
	

	// Get student by ID------

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") Long id, Model model) {
		System.out.println("----------------------************************");
		Student student = studentService.getStudentByID(id);
		model.addAttribute("student", student);
		return "editStudent";
	}

	// Update existing student-----
	/*@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute("newStudent") Student student, RedirectAttributes rm, Model model, @PathVariable("id") Long id) {
		System.out.println("999999999999999999999999999999999999999999999999999999999999");

		// rm.addFlashAttribute("studentDeleteMessage", "Student has been
		// successfully deleted!");
		// Long id = student.getId();
		// studentService.getStudentByID(id);

		studentService.saveStudent(student);
		// List<Student> listOfStudents = studentService.getAllStudent();
		List<Student> students = studentService.getAllStudent();
		model.addAttribute("listOfStudent", students);
		// return "listStudent";

		// studentService.deleteStudentByID(id);
		// return new ResponseEntity<Void>(HttpStatus.OK);
		return "redirect:/employee/listStudent";
		// return "studentList";
	}*/

	// Delete student -----

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, RedirectAttributes rm, Model model) {
		rm.addFlashAttribute("studentDeleteMessage", "Student has been successfully deleted!");
		studentService.deleteStudentByID(id);
		List<Student> listOfStudents = studentService.getAllStudent();
		model.addAttribute("listStudent", listOfStudents);
		return "listStudent";
	}

}
