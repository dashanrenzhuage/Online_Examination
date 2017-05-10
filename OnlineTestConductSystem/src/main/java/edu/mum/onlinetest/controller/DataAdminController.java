package edu.mum.onlinetest.controller;

import java.io.File;
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
	
	@RequestMapping( method = RequestMethod.GET)
	public String dataAdminHome(){
		return "data_admin_home";
	}
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.GET)
	public String uploadFilePage(@ModelAttribute("subcategory") SubCategory subcategory, @ModelAttribute("newProduct") FileUpload newProduct, Model model){
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("listOfCategory", categories);
		return "fileUpload";
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") FileUpload newProduct, HttpServletRequest request) {
		System.out.println(" im here");
		//start here
		MultipartFile productImage = newProduct.getUploadFile();
		
		String path = context.getRealPath("/resources/file/");

		String fileName = newProduct.getUploadFile().getOriginalFilename();
		
		//isEmpty means file exists BUT NO Content
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
		    	   
		      	productImage.transferTo(new File(path+ fileName));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }

		return "redirect:/dataAdmin/uploadFile";
	}
	
	
}
