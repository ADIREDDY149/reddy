package com.slokam.FamilyServelet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServelet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	
	
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

	
	String user=req.getParameter("user");
	String password=req.getParameter("password");
	String nextpage="login.jsp";
	if(user.equals(password)){
		
		
		ArrayList<String> activeusers=(ArrayList<String>)req.getServletContext().getAttribute("activeusers");
		if(activeusers!=null && activeusers.contains(user)){
			req.getSession().setAttribute("message", "user already login..try diffrent user/pwd");
			nextpage="login.jsp";
			
		}else{
		if(activeusers==null){
			activeusers=new ArrayList<String>();
			activeusers.add(user);
		
		req.getServletContext().setAttribute("activeusers", activeusers);

		req.getSession().setAttribute("user", user);
		Random random=new Random();
	Integer otp=	random.nextInt();
	System.out.println("otp is::"+otp);
	
	req.getSession().setAttribute("otp", otp);
	
		nextpage="WEB-INF/otp.jsp";
	}
		}
		}
	req.getRequestDispatcher(nextpage).forward(req, res);
}
}
