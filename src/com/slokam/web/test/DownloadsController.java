package com.slokam.web.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadsController {

	@RequestMapping("downloads")
	public ModelAndView downloads(){
		
		File file=new File("E:\\uploads\\");
		
		
		String[] fileNames=file.list();
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("fileNamesAtt",fileNames);
		mv.setViewName("displayfiles.jsp");
		return mv;
	}
	@RequestMapping("downloadFile")
	public void downloadFile(String fileName,HttpServletResponse res){
		
		res.setHeader("content-disposition", "attachment;filename="+fileName);
		File file=new File("E:\\uploads\\"+fileName);
		
		try {
			PrintWriter pw=res.getWriter();
			FileInputStream fis=new FileInputStream(file);
			
			int data=fis.read();
			while(data!=-1){
				
				pw.write(data);
				data=fis.read();
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
