package com.slokam.as.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slokam.as.pojo.studentpojo;
import com.slokam.as.service.studentservice;

@Controller
public class TestController {

	
	@Autowired
	private studentservice studentservice;
	
	@RequestMapping("savedata")
	public @ResponseBody void savedata(@RequestBody studentpojo std){
		
		studentservice.savedata(std);
	}
	@RequestMapping("getall")
	public @ResponseBody List<studentpojo> getall(){
		
		List<studentpojo> student=studentservice.GetallData();
		return student;
	}
	@RequestMapping("GetById")
	public @ResponseBody studentpojo GetById(Integer id){
		
		studentpojo student=studentservice.GetById(id);
		return student;
	}
	@RequestMapping("delete")
	public @ResponseBody void delete(@RequestBody studentpojo std){
		
		studentservice.delete(std);
	}
	
	@RequestMapping("update")
	public @ResponseBody void update(@RequestBody studentpojo std){
		
		studentservice.update(std);
	}
	
	
}
