package com.slokam.FamilyServelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Otpservelet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String userotp=req.getParameter("otp");
	
	Integer otp=(Integer)req.getSession().getAttribute("otp");
	
	String otpstr=otp+"";
	
	String nextpage="login.jsp";
	
	if(userotp.equals(otpstr)){
		
		req.setAttribute("message", "Otp is sended");
		
		nextpage="WEB-INF/family.jsp";
	}
	req.getRequestDispatcher(nextpage).forward(req, res);
}
}
