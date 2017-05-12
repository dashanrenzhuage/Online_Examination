package edu.mum.onlinetest.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import edu.mum.onlinetest.model.Marksheet;
import edu.mum.onlinetest.model.Student;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.ReportServiceInterface;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class ReportServiceImpl implements ReportServiceInterface{
	
	@Autowired
	StudentServiceImpl studentService;

	@Override
	public JRDataSource getDataSourceStudent(Long id) {
		System.out.println("************************* service1");
		List<Marksheet> items = new ArrayList<>();
		Student student = studentService.getStudentByID(id);
		//List<SubCategory> subCategoryList = student.getTest().getSubCategories();
		
		//added for dummydata
		/*List<SubCategory>subcat = new ArrayList<>();
		SubCategory sub = new SubCategory();
		sub.setSubCatName("CoreJava");
		SubCategory sub1 = new SubCategory();
		sub.setSubCatName("Spring");
		subcat.add(sub1);
		subcat.add(sub);*/
		
		for(int i = 0; i < 3/*subCategoryList.size()*/; i++){
			Marksheet marksheet = new Marksheet();
			marksheet.setStudentId(student.getId());
			marksheet.setName(student.getName());
			/*marksheet.setEmail(student.getEmail());
			marksheet.setAddress(student.getAddress());
			marksheet.setCategory(student.getTest().getSubCategories().get(0).getCategory().getName().toString());
			marksheet.setSubCategoryName(student.getTest().getSubCategories().get(i).getSubCatName().toString());*/
			/*marksheet.setStudentId((long) 22);
			marksheet.setName("Sushil Pokhrel");
			marksheet.setEmail("sp@gmail.com");*/
			marksheet.setAddress("1000 N 4th ST");
			marksheet.setCategory("Java");
			marksheet.setSubCategoryName("Core Java");
			marksheet.setIndividualMark(16);
			marksheet.setIndividualGrade("A-");
			marksheet.setOverallGrade("A-");
			marksheet.setTotalMarksObtained(35);
			System.out.println(marksheet.getSubCategoryName());
			items.add(marksheet);
		}
		System.out.println("************************* service2");
		
		JRDataSource ds = new JRBeanCollectionDataSource(items);
		return ds;
	}
}
