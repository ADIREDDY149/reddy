package com.slokam.FamilyServelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slokam.FamilyDao.familyDao;
import com.slokam.pojo.familypojo;

public class FamilySaveServelet extends HttpServlet {
@Override
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	Integer reqcount=(Integer)req.getSession().getAttribute("reqcount");
	
	if(reqcount==null){
		reqcount=1;
	}else{
		reqcount++;
	}
	
	req.getSession().setAttribute("reqcount", reqcount);
	Integer totalcount=(Integer)req.getServletContext().getAttribute("totalcount");
	if(totalcount==null){
		totalcount=1;
	}else{
		totalcount++;
	}
	req.getServletContext().setAttribute("totalcount", totalcount);
	
	PrintWriter pw=res.getWriter();
	
	
	String name=req.getParameter("name");
	String age=req.getParameter("age");
	String fname=req.getParameter("fname");
	String mname=req.getParameter("mname");
	String address=req.getParameter("address");
	String phone=req.getParameter("phone");
	
	
	
	familypojo family=new familypojo();
	
	family.setName(name);
	family.setAge(age);
	family.setFname(fname);
	family.setMname(mname);
	family.setAddress(address);
	family.setPhone(phone);
	
	familyDao data=new familyDao();
	
	data.FamilyDetailsSave(family);
	
	req.setAttribute("message", "save sucesssfully");
	
	req.getRequestDispatcher("WEB-INF/family.jsp").forward(req, res);
	
	
}
}
