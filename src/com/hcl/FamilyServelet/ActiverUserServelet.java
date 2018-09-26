package com.slokam.FamilyServelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActiverUserServelet extends HttpServlet {
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	
	arg0.getRequestDispatcher("WEB-INF/Activeusers.jsp").forward(arg0, arg1);
	
}
}
