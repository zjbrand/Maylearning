package com.eden.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.eden.anno.Log;
import com.eden.entity.Employee;
import com.eden.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Value("${file.upload.dir}")
	private String realpath;
	
	@RequestMapping("search")
	public String searchEmp(String dateBegin,String dateEnd,String topSalary,
			String lowSalary, String searchName,Model model) {
		
		dateBegin=dateBegin.trim();
		dateEnd=dateEnd.trim();
		topSalary=topSalary.trim();
		lowSalary=lowSalary.trim();
		searchName=searchName.trim();
		
		log.info("開始時間：{},完了時間：{},最高給料：{},最低給料：{},名前：{}",dateBegin,dateEnd,topSalary,lowSalary,searchName);
		
		List<Employee> employee=employeeService.searchEmp(dateBegin,dateEnd,topSalary,lowSalary,searchName);
		
		model.addAttribute("employeeList", employee);
		
		return "emplist";
	}
	
	@Log
	@RequestMapping("delete")
	public String delete(Integer id) {
		log.info("削除の社員ID：{}",id);
		
		String photo = employeeService.findById(id).getPhoto();
		
		File file=new File(realpath,photo);
		if(file.exists()) file.delete();
		
		employeeService.delete(id);
		
		return "redirect:/employee/lists";
	}
	
	@Log
	@RequestMapping("update")
	public String update(Employee employee,MultipartFile img) throws IllegalStateException, IOException {
		log.info("更新した社員ID：{},名前：{},給与：{},誕生日：{}",
				employee.getId(),employee.getName(),employee.getSalary(),employee.getBirthday());
		boolean notempty=!img.isEmpty();
		log.info("写真更新するかどうか：{}",notempty);
		
		if(notempty) {
			String oldphoto=employeeService.findById(employee.getId()).getPhoto();
			
			File file= new File(realpath,oldphoto);
			
			if(file.exists()) {
				file.delete();
			}
			
			String originalFilename = img.getOriginalFilename();
			
			//抽出するメソッド
			String newFileName = uploadPhoto(img,originalFilename);			
			
			employee.setPhoto(newFileName);
		}
		
		/*if(employee.getPhoto().isEmpty()) {
			employee.setPhoto(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		}*/
		
		employeeService.update(employee);
				
		return "redirect:/employee/lists";
	}	
	
	@RequestMapping("detail")
	public String detail(Integer id,Model model) {
		log.info("更新ID：{}",id);
		
		Employee employee= employeeService.findById(id);
		
		model.addAttribute("employee",employee);
		return "updateEmp";
	}
	
	@Log
	@RequestMapping("save")
	public String save(Employee employee,MultipartFile img) throws IllegalStateException, IOException {
		log.debug("名前：{},給料：{},誕生日：{}",employee.getName(),employee.getSalary(),employee.getBirthday());
		String originalFilename = img.getOriginalFilename();
		log.debug("ファイルの名：{},ファイルのサイズ：{},アップロードアドレス：{}",originalFilename,img.getSize(),realpath);
		
		String newFileName = uploadPhoto(img,originalFilename);	
		
		employee.setPhoto(newFileName);
		
		employeeService.save(employee);
		
		return "redirect:/employee/lists";
	}

	@GetMapping("lists")
	public String lists(Model model) {
		log.debug("全部社員を照会する");
		
		List<Employee> employeeList= employeeService.lists();
		
		model.addAttribute("employeeList", employeeList);
		return "emplist";
	}
	
	private String uploadPhoto(MultipartFile img,String originalFilename) throws IllegalStateException, IOException {		
		
		
		String fileNamePrefix = originalFilename.substring(0,originalFilename.lastIndexOf("."));
		
		String fileTime=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		
		String fileNamesuffix =originalFilename.substring(originalFilename.lastIndexOf("."));//.gif
		
		String newFileName=fileNamePrefix+fileTime+fileNamesuffix;
		
		img.transferTo(new File(realpath,newFileName));
		
		return newFileName;
	}
}
