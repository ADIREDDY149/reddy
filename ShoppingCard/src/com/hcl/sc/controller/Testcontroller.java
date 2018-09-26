package com.slokam.sc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.slokam.sc.pojo.billpojo;
import com.slokam.sc.pojo.loginpojo;
import com.slokam.sc.pojo.sellerpojo;
import com.slokam.sc.service.SellerService;



@Controller
public class Testcontroller {
	
	
	String name=null;
	@Autowired
	private SellerService sellerservice;
@RequestMapping("test")
	public ModelAndView test(){
	
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("seller", new sellerpojo());
		mv.setViewName("login.jsp");
		return mv;
	}
@RequestMapping("login")
public ModelAndView login(loginpojo login){
	 String name=login.getUsername();
	ModelAndView mv=new ModelAndView();
	if(login.getUsername().equals(login.getPassword()))
	{
		mv.addObject("seller", new sellerpojo());
		mv.addObject("username",name);
		mv.setViewName("seller.jsp");
	}
	else{
	
	mv.setViewName("login.jsp");
	System.out.println(" iam in login controller");
	}
	return mv;
}
/*@RequestMapping("bill")
public ModelAndView Bill(billpojo bill){
	ModelAndView mv=new ModelAndView();
	
	mv.addObject("bill",new billpojo());
	mv.setViewName("bill.jsp");
	sellerservice.billsave(bill);
	return mv;
}*/
@RequestMapping("saveseller")
public ModelAndView save(sellerpojo seller ){
	ModelAndView mv=new ModelAndView();
	
	mv.addObject("seller", new sellerpojo());
	mv.setViewName("seller.jsp");
	mv.addObject("username",name);
	sellerservice.SellerSave(seller);
	return mv;
}
@RequestMapping("getallseller")
public ModelAndView getallseller(){
	ModelAndView mv=new ModelAndView();
	List<sellerpojo> sellers =sellerservice.getallseller();
	mv.addObject("sellers", sellers);
	mv.addObject("username",name);
	mv.addObject("seller", new sellerpojo());
	mv.setViewName("buyier.jsp");
	return mv;
}

@RequestMapping("getsellerById")
public ModelAndView getsellerById(Integer id){
	ModelAndView mv=new ModelAndView();
	sellerpojo seller =sellerservice.getsellerById(id);
	mv.addObject("seller", seller);
	mv.addObject("username",name);
	mv.addObject("bill", new billpojo());
	mv.setViewName("bill.jsp");
	return mv;
}
@RequestMapping("Updateseller")
public ModelAndView updatestudent(sellerpojo seller){
	ModelAndView mv=new ModelAndView();
	sellerservice.Updateseller(seller);
	mv.addObject("username",name);
	mv.addObject("seller", new sellerpojo());
	mv.setViewName("seller.jsp");
	return mv;
	
}
@RequestMapping("Deleteseller")
public ModelAndView Deletestudent(sellerpojo seller){
	ModelAndView mv=new ModelAndView();
	sellerservice.Deleteseller(seller);
	mv.addObject("seller", new sellerpojo());
	mv.setViewName("seller.jsp");
	return mv;
	
}
}
