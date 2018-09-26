package com.slokam.FamilyServelet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slokam.FamilyDao.familyDao;
import com.slokam.pojo.familypojo;

public class UpdateFamilyServelet  extends HttpServlet{

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
		
		
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String fname=req.getParameter("fname");
		String mname=req.getParameter("mname");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		int id1=Integer.parseInt(id);
		
		familypojo fam=new familypojo();
		
		fam.setId(id1);
		fam.setName(name);
		fam.setAge(age);
		fam.setFname(fname);
		fam.setMname(mname);
		fam.setAddress(address);
		fam.setPhone(phone);
		
		
		
		familyDao data=new familyDao();
		
		
		data.UpdateFamily(fam);
		req.setAttribute("message", "update sucessfully");
		req.getRequestDispatcher("WEB-INF/family.jsp").forward(req, res);
	}

}
