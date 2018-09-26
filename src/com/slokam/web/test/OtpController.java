package com.slokam.web.test;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.slokam.web.test.Service.CountryService;
import com.slokam.web.test.pojo.Countrypojo;
import com.slokam.web.test.pojo.studentpojo;

@Controller
public class OtpController {
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("otpcheck")
	public ModelAndView otpcheck(Integer otp,HttpSession session){
		
		ModelAndView mv=new ModelAndView();
		Integer genOtp=(Integer)session.getAttribute("otp");
		if(genOtp!=null){
			if(otp.equals(genOtp)){
				
			mv.setViewName("student.jsp");
			List<Countrypojo> countries=countryService.getAllCountrys();
			mv.addObject("countries", countries);
			mv.addObject("student", new studentpojo());
			
		
		}else{
			
			mv.setViewName("otp.jsp");
		}
	}
		return mv;
	}
	
	
}
