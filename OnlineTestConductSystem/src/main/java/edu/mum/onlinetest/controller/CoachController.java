package edu.mum.onlinetest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.onlinetest.model.Email;
import edu.mum.onlinetest.model.Student;
import edu.mum.onlinetest.serviceImpl.CoachServiceImpl;
import edu.mum.onlinetest.serviceImpl.MailServiceImpl;
import edu.mum.onlinetest.serviceImpl.StudentServiceImpl;

@Controller
@RequestMapping("coach")
public class CoachController {

	@Autowired
	CoachServiceImpl coachService;
	@Autowired
	MailServiceImpl mailService;
	@Autowired
	StudentServiceImpl studentService;

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public String generateId(@PathVariable("id") Long id, Model model, RedirectAttributes rm) {
		// LOG.info("deleting category with id: {}", id);
		String accessId = coachService.generateId();
		System.out.println(accessId);

		Student student = studentService.getStudentByID(id);

		System.out.println(student);
		String body = "Here is the information for login." + "\n" + "Link :"
				+ "http://localhost:8080/OnlineTestConductSystem/test" + "\n" + "Accessid : " + accessId;
		String subject = "AccessID and Link for Test";

		Email email = new Email(student.getName(), student.getEmail(), subject, body);
		mailService.sendMail(email);
		//model.addAttribute("successMessage", "");
		rm.addFlashAttribute("successMessage", "Email Successfully sent!");
		// return new ResponseEntity<Void>(HttpStatus.OK);
		return "redirect:/coach/studentList";
	}
	
	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public String showStudentList(Model model) {
		// LOG.info("deleting category with id: {}", id);
		List<Student> listOfStudents = studentService.getAllStudent();
		model.addAttribute("listOfStudents", listOfStudents);

		// return new ResponseEntity<Void>(HttpStatus.OK);
		return "list_student_detail";
	}

}
