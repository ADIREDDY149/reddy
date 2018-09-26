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

public class GetByIdServelet extends HttpServlet {

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
	
		familyDao data=new familyDao();
		
		familypojo family=data.GetDetailsById(Integer.parseInt(id));
		
		req.setAttribute("getdata",family );
		req.getRequestDispatcher("WEB-INF/family.jsp").forward(req, res);
		
	}

}
