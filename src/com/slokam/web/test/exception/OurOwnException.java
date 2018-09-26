package com.slokam.web.test.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.slokam.web.test.Service.CountryService;
import com.slokam.web.test.pojo.Countrypojo;
import com.slokam.web.test.pojo.studentpojo;

@ControllerAdvice
public class OurOwnException {
	
	@Autowired
	private CountryService countryService;
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handlerException(RuntimeException re){
		
		re.printStackTrace();
		System.out.println("this is handlerexception...");
		ModelAndView mv=new ModelAndView();
		
		
		mv.addObject("error", "this is inccorrect please contact admin");
		mv.setViewName("student.jsp");
		mv.addObject("student", new studentpojo());
		return mv;
	}
	
	
}
