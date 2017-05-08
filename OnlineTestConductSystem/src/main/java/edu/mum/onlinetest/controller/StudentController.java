package edu.mum.onlinetest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.Student;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.CategoryServiceInterface;
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
					// List<SubCategory> listOfSubCategories =
					// subCategoryService.getSubCategoryByID(id);
					List<SubCategory> listOfSubCategories = subCategoryService.getAllSubCategory();
					model.addAttribute("listOfCategories", listOfCategories);
					model.addAttribute("listOfSubcategories", listOfSubCategories);

					// access-code delete after login
					student.setAccessCode(null);
					studentService.saveStudent(student);

					return "stu_sel_exam";
				}
			}

		}
		return "stu_login";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String showAddStudentPage(Model model) {
		return "addStudent";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("listOfStudents", studentService.getAllStudent());
		return "coach_home_page";
	}

	// Get student by ID------

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") Long id, Model model) {
		System.out.println("----------------------************************");
		Student student = studentService.getStudentByID(id);
		model.addAttribute("student", student);
		return "editStudent";
	}

	// Add student ------

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
		studentService.saveStudent(student);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Update existing student-----
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public String update(@ModelAttribute Student student, RedirectAttributes rm, Model model) {

		// rm.addFlashAttribute("studentDeleteMessage", "Student has been
		// successfully deleted!");
		//Long id = student.getId();

		studentService.saveStudent(student);
		// List<Student> listOfStudents = studentService.getAllStudent();
		List<Student> students = studentService.getAllStudent();
		model.addAttribute("listOfStudent", students);
		// return "listStudent";

		// studentService.deleteStudentByID(id);
		// return new ResponseEntity<Void>(HttpStatus.OK);
		return "redirect:/employee/listStudent";
		// return "studentList";
	}

	// Delete student -----

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, RedirectAttributes rm) {

		System.out.println("here im");
		System.out.println("**************************************");
		System.out.println(id);

		rm.addFlashAttribute("studentDeleteMessage", "Student has been successfully deleted!");
		studentService.deleteStudentByID(id);
		// return new ResponseEntity<Void>(HttpStatus.OK);
		return "redirect:/employee/listStudent";
		// return "studentList";
	}


	

}
