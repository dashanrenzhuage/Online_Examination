package edu.mum.onlinetest.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.FileUpload;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.CategoryServiceInterface;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;

@Controller
@RequestMapping("/question")
public class QuestionUploadController {
	@Autowired
	ServletContext context;

	@Autowired
	QuestionServiceInterface questionService;

	@Autowired
	SubCategoryInterface subcategoryService;

	@Autowired
	private CategoryServiceInterface categoryService;

	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public String uploadFilePage(@ModelAttribute("subcategory") SubCategory subcategory,
			@ModelAttribute("questionFile") FileUpload questionFile, Model model) {
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("listOfCategory", categories);
		return "fileUpload";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadQuestionFile(@Valid @ModelAttribute("questionFile") FileUpload questionFile,
			@RequestParam("subCateroryId") Long subCateroryId, BindingResult result) {
		if (result.hasErrors()) {
			return "fileUpload";
		}
		System.out.println("Uploading file...");
		System.out.println("Sub Cateogy: " + subCateroryId);
		
		String fileName = questionService.getUploadedFileName(questionFile); 
		/*
		String uploadPath = System.getProperty("catalina.home") + File.separator + "onlinetestconductsystem"
				+ File.separator + "questions" + File.separator;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		// start here
		MultipartFile file = questionFile.getUploadFile();

		// isEmpty means file exists BUT NO Content
		
		if (file != null && !file.isEmpty()) {
			try {
				fileName = questionFile.getUploadFile().getOriginalFilename();
				String filePath = uploadPath + File.separator + fileName;
				System.out.println("Path of file:" + filePath);
				File storeFile = new File(filePath);
				file.transferTo(storeFile);
			} catch (Exception e) {
				throw new RuntimeException("File saving failed", e);
			}
		}*/
		if (fileName != null) {
			System.out.println(fileName);
			questionService.saveALLQuestion(questionService.uploadQuestion(subCateroryId, fileName));
			return "redirect:/question/uploadFile";
		}
		return "redirect:/question/uploadFile";
	}

	/* ======================================== */

	/*
	 * @RequestMapping(value = "/upload", method = RequestMethod.POST) public
	 * String upload(@ModelAttribute("subcategory") SubCategory subcategory,
	 * HttpServletRequest request) { String fileName =
	 * request.getParameter("fileName"); System.out.println(fileName);
	 * questionService.saveALLQuestion(questionService.uploadQuestion(
	 * subcategory.getId(), fileName)); return "redirect:/dataAdmin/uploadFile";
	 * }
	 */

	@RequestMapping(value = "/generateTTSS", method = RequestMethod.POST)
	public void questionGenerate(@ModelAttribute("category") Category category, BindingResult result) {

		List<Long> quesId = questionService.findIdByName("spring");
		for (Long id : quesId) {
			System.out.println("questionId: " + id);
		}

	}

}
