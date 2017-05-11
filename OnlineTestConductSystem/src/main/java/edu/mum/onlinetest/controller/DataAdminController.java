package edu.mum.onlinetest.controller;

import java.io.File;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.FileUpload;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.CategoryServiceInterface;

@Controller
@RequestMapping("/dataAdmin")
public class DataAdminController {
	@Autowired
	ServletContext context;

	@Autowired
	CategoryServiceInterface categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public String dataAdminHome() {
		return "data_admin_home";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public String uploadFilePage(@ModelAttribute("subcategory") SubCategory subcategory,
			@ModelAttribute("newProduct") FileUpload newProduct, Model model) {
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("listOfCategory", categories);
		return "fileUpload";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") FileUpload questionFile,
			HttpServletRequest request) {
		System.out.println("Uploading file...");
		String uploadPath = System.getProperty("catalina.home") + File.separator + "onlinetestconductsystem"
				+ File.separator + "questions" + File.separator;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		// start here
		MultipartFile file = questionFile.getUploadFile();

		/*
		 * String path = context.getRealPath("/resources/file/"); URL url =
		 * this.getClass().getClassLoader().getResource("/file");
		 * System.out.println(url.toString());
		 */

		// isEmpty means file exists BUT NO Content
		if (file != null && !file.isEmpty()) {
			try {
				String fileName = questionFile.getUploadFile().getOriginalFilename();
				String filePath = uploadPath + File.separator + fileName;
				System.out.println("Path of file:" + filePath);
				File storeFile = new File(filePath);
				file.transferTo(storeFile);
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}

		return "redirect:/dataAdmin/uploadFile";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";

	}

}
