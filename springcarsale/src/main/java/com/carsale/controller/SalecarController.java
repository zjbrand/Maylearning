package com.carsale.controller;

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

import com.carsale.anno.Log;
import com.carsale.entity.Salecar;
import com.carsale.service.SalecarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("salecar")
public class SalecarController {
	
	@Autowired
	private SalecarService salecarService;
	
	@Value("${file.upload.dir}")
	private String realpath;
	
	@RequestMapping("search")
	public String searchCar(String dateBegin,String dateEnd,String topSalary,
			String lowSalary, String searchName,Model model) {
		
		dateBegin=dateBegin.trim();
		dateEnd=dateEnd.trim();
		topSalary=topSalary.trim();
		lowSalary=lowSalary.trim();
		searchName=searchName.trim();
		
		log.info("生産時間開始時間：{},生産時間完了時間：{},最高価格：{},最低価格：{},車の型：{}",dateBegin,dateEnd,topSalary,lowSalary,searchName);
		
		List<Salecar> salecar=salecarService.searchCar(dateBegin,dateEnd,topSalary,lowSalary,searchName);
		
		model.addAttribute("carList", salecar);
		
		return "carlist";
	}
	
	@Log
	@RequestMapping("delete")
	public String delete(Integer id) {
		log.info("削除の車輌ID：{}",id);
		
		String photo = salecarService.findById(id).getPhoto();
		
		File file=new File(realpath,photo);
		if(file.exists()) file.delete();
		
		salecarService.delete(id);
		
		return "redirect:/salecar/lists";
	}
	
	@Log
	@RequestMapping("update")
	public String update(Salecar salecar,MultipartFile img) throws IllegalStateException, IOException {
		log.info("更新した車輌ID：{},ブランド：{},生産時間：{},価格：{},里程：{},保有者：{},性別：{},{},{}",
				salecar.getCarid(),salecar.getCarBrand(),salecar.getProduceDate(),salecar.getSalePrice(),
				salecar.getOdometer(),salecar.getOwner(),salecar.isGender(),salecar.getPhonenum(),salecar.getAddress());
		boolean notempty=!img.isEmpty();
		log.info("写真更新するかどうか：{}",notempty);
		
		if(notempty) {
			String oldphoto=salecarService.findById(salecar.getCarid()).getPhoto();
			
			File file= new File(realpath,oldphoto);
			
			if(file.exists()) {
				file.delete();
			}
			
			String originalFilename = img.getOriginalFilename();
			
			//抽出するメソッド
			String newFileName = uploadPhoto(img,originalFilename);			
			
			salecar.setPhoto(newFileName);
		}
		
		/*if(employee.getPhoto().isEmpty()) {
			employee.setPhoto(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		}*/
		
		salecarService.update(salecar);
				
		return "redirect:/salecar/lists";
	}	
	
	@RequestMapping("detail")
	public String detail(Integer carid,Model model) {
		log.info("更新ID：{}",carid);
		
		Salecar salecar= salecarService.findById(carid);
		
		model.addAttribute("salecar",salecar);
		return "updateCar";
	}
	
	@Log
	@RequestMapping("save")
	public String save(Salecar salecar,MultipartFile img) throws IllegalStateException, IOException {
		log.debug("名前：{},給料：{},誕生日：{}",salecar.getCarBrand());
		String originalFilename = img.getOriginalFilename();
		log.debug("ファイルの名：{},ファイルのサイズ：{},アップロードアドレス：{}",originalFilename,img.getSize(),realpath);
		
		String newFileName = uploadPhoto(img,originalFilename);	
		
		salecar.setPhoto(newFileName);
		
		salecarService.save(salecar);
		
		return "redirect:/salecar/lists";
	}

	@GetMapping("lists")
	public String lists(Model model) {
		log.debug("全部車輌を照会する");
		
		List<Salecar> carList= salecarService.lists();
		
		model.addAttribute("carList", carList);
		return "carlist";
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
