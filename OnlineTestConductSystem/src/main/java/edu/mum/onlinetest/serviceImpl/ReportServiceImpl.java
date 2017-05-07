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

	/*@Override
	public JRDataSource getDataSourceStudent(Long id) {
		List<Marksheet> items = new ArrayList<>();
		Student student = studentService.getStudentByID(id);
		
		Marksheet marksheet = new Marksheet();
		marksheet.setStudentId(student.getId());
		marksheet.setName(student.getName());
		marksheet.setEmail(student.getEmail());
		marksheet.setAddress(student.getAddress());
		items.add(marksheet);
		
		
		List<SubCategory> subCategoryList = student.getTest().getSubCategories();

		List<Object> oblist = new ArrayList<>();
		oblist.add(marksheet);
		System.out.println(oblist.get(0));

		for(int i = 0; i < subCategoryList.size(); i++){
			oblist.add(subCategoryList.get(i));
			System.out.println(oblist.get(i));

		}
		
		
		//oblist.addAll(subCategoryList);
		
		JRDataSource ds = new JRBeanCollectionDataSource(oblist);
		
		
		
		//JRDataSource ds = new JRBeanCollectionDataSource(items);	
		return ds;
	}*/
	
	/*@Override
	public JRDataSource getDataSourceSubCategories(Long id) {
		Student student = studentService.getStudentByID(id);
		List<SubCategory> subCategoryList = student.getTest().getSubCategories();
		List<SubCategory> items = new ArrayList<>();
		items.addAll(subCategoryList);		
		JRDataSource ds = new JRBeanCollectionDataSource(items);	
		return ds;
	}
	*/
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
			items.add(marksheet);
		}
		System.out.println("************************* service2");
		JRDataSource ds = new JRBeanCollectionDataSource(items);
		return ds;
	}
	
	
	/*public JRDataSource getDataSource1(Long id) {
		List<Marksheet> items = new ArrayList<>();
		
		
		Student student = studentService.getStudentByID(id);
		
		Marksheet marksheet = new Marksheet();
		marksheet.setStudentId(student.getId());
		marksheet.setName(student.getName());
		marksheet.setEmail(student.getEmail());
		marksheet.setAddress(student.getAddress());
		marksheet.setCategory(student.getTest().getCategory());
		items.add(marksheet);
		
		
		
		//List<Student> studentList = new ArrayList<>();
		
		List<SubCategory> subCategoryList = student.getTest().getSubCategories();
		Student student = studentService.getStudentByID(id);
		
		
		
		
		
		
		JRDataSource ds = new JRBeanCollectionDataSource(items);	
		return ds;
	}
	
	
	public ModelAndView BMIbyage(ModelAndView modelAndView, ModelMap model, Map<String, Object> map,HttpServletRequest request,
	        @RequestParam("syear") int syear,@RequestParam("eyear") int eyear,HttpSession session){
	    String childid = (String) session.getAttribute("childid");

	    List<AdmissionSummery> asum = new ArrayList<AdmissionSummery>();

	     List<PatientDetails> patientdetail = patientService.listpatientbmi();

	    for(int i=syear;i<=eyear;i++){
	         asum.add(new AdmissionSummery());
	        int no=0;
	        for(int j=0;j<patientdetail.size();j++){


	            int dob = Integer.parseInt(patientdetail.get(j).getDateofbirth().substring(0, 4));

	            float bmi = patientService.listPatient(patientdetail.get(j).getChildid()).get(0).getBmi();


	            if(dob ==i && (bmi<18.5)){
	                no=no+1;

	                asum.get(asum.size()-1).setNooftime(no);

	            }
	            System.out.println("no"+no);
	            System.out.println("j"+j);
	            asum.get(asum.size()-1).setDuration(syear+" "+"-"+" "+eyear);
	            asum.get(asum.size()-1).setYear(i);


	            System.out.println("BMI"+bmi);

	        }



	        System.out.println("i"+i);
	    }

	      JRDataSource datasource = new JRBeanCollectionDataSource(asum);   

	        model.addAttribute("datasourcebmireportA", datasource);

	        model.addAttribute("format", "pdf");

	        modelAndView = new ModelAndView("pdfReportViewaddsummeryA", model);



	    return modelAndView;


	}
*/

	

}
