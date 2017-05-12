package edu.mum.onlinetest.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
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
import edu.mum.onlinetest.model.Test;
import edu.mum.onlinetest.service.ReportServiceInterface;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class ReportServiceImpl implements ReportServiceInterface{
	
	@Autowired
	StudentServiceImpl studentService;
	@Autowired
	TestServiceImpl testService;
	@Autowired
	GradingServiceImpl gradingService;

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
		int a = testService.getALlbyStudentId(id).size();

		Map<String, Integer> abc = testService.getALlbyStudentId(id).get(a-1).getIndividualMark();
		
		Iterator it = abc.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			String subcatname = (String) pair.getKey();
			
			
			
			Integer individualMark = (Integer) pair.getValue();
			
			Marksheet marksheet = new Marksheet();
			marksheet.setStudentId(student.getId());
			marksheet.setName(student.getName());
			marksheet.setEmail(student.getEmail());
			marksheet.setAddress(student.getAddress());
			//marksheet.setCategory("Java");
			marksheet.setCategory(testService.getALlbyStudentId(id).get(a-1).getCategory());
			marksheet.setSubCategoryName(subcatname);
			marksheet.setIndividualMark(individualMark);
			String individualGrade = gradingService.calculateGrade(individualMark, 10);
			marksheet.setIndividualGrade(individualGrade);
			//marksheet.setIndividualGrade("A-");
			
			int totalMark = testService.getALlbyStudentId(id).get(a-1).getTotalmarks();
			
			String totalGrade = gradingService.calculateGrade(totalMark, 30);
			marksheet.setOverallGrade(totalGrade);
			marksheet.setTotalMarksObtained(testService.getALlbyStudentId(id).get(a-1).getTotalmarks());
			items.add(marksheet);

			
		}
		
		
		JRDataSource ds = new JRBeanCollectionDataSource(items);
		return ds;
	}
}
