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
		List<SubCategory> subCategoryList = student.getTest().getSubCategories();
		for(int i = 0; i < subCategoryList.size(); i++){
			Marksheet marksheet = new Marksheet();
			marksheet.setStudentId(student.getId());
			marksheet.setName(student.getName());
			marksheet.setEmail(student.getEmail());
			marksheet.setAddress(student.getAddress());
			marksheet.setCategory(student.getTest().getSubCategories().get(0).getCategory().getName().toString());
			marksheet.setSubCategoryName(student.getTest().getSubCategories().get(i).getSubCatName().toString());
			marksheet.setIndividualGrade("A+");
			marksheet.setIndividualMark(16);
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
