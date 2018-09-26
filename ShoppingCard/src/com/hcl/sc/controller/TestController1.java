package com.slokam.sc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.slokam.sc.pojo.billpojo;
import com.slokam.sc.pojo.sellerpojo;
import com.slokam.sc.service.SellerService;

@Controller
public class TestController1 {
	//this class is buyerpage link clicks goto bill.jsp(i.e order)page...
	String name=null;
	@Autowired
	private SellerService sellerservice;
	@RequestMapping("bill")
	public ModelAndView Bill(billpojo bill){
		String username=name;
		ModelAndView mv=new ModelAndView();
		sellerservice.billsave(bill);
		mv.addObject("username",name);
		mv.addObject("bill",new billpojo());
		mv.setViewName("bill.jsp");
		return mv;
	}
	//get all in orderlist in seller.jsp
	@RequestMapping("getbill")
	public ModelAndView getBill(){
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("username",name);
		List<billpojo> bills= sellerservice.getbill();
		mv.addObject("bills", bills);
		mv.addObject("bill", new billpojo());
		mv.setViewName("bill.jsp");
		
		return mv;
	}
	// get by id click to goto bill.jsp we can udate address and name and quantity..
	@RequestMapping("getBuyuyerById")
	public ModelAndView getBuyuyerById(Integer id){
		ModelAndView mv=new ModelAndView();
		billpojo bill =sellerservice.getBuyuyerById(id);
		mv.addObject("username",name);
		mv.addObject("bill", bill);
	
		mv.setViewName("bill.jsp");
		return mv;
	}
	
	@RequestMapping("Updateorder")
	public ModelAndView updatestudent(billpojo bill){
		ModelAndView mv=new ModelAndView();
		sellerservice.Updateorder(bill);
		mv.addObject("bill", new billpojo());
		mv.setViewName("bill.jsp");
		mv.addObject("username",name);
		return mv;
		
	}
	@RequestMapping("Deleteorder")
	public ModelAndView Deletestudent(billpojo bill){
		ModelAndView mv=new ModelAndView();
		sellerservice.Deleteorder(bill);
		mv.addObject("bill", new billpojo());
		mv.addObject("username",name);
		mv.setViewName("bill.jsp");
		return mv;
		
	}
}
