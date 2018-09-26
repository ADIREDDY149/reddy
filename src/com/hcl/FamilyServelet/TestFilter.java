package com.slokam.FamilyServelet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TestFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("dofilter start.....");
		HttpServletRequest request=(HttpServletRequest)arg0;
		String uri=request.getRequestURI();
		System.out.println("uri is::"+uri);
		if(uri.equals("/FamilyDetails/login.jsp") || uri.equals("/FamilyDetails/login")){
			
			arg2.doFilter(arg0, arg1);
		}else{
			
			String user=(String)request.getSession().getAttribute("user");
			if (user==null){
				
				arg0.setAttribute("message", "Please login....");
				arg0.getRequestDispatcher("login.jsp").forward(arg0, arg1);
				return ;
			 }else{
				 arg2.doFilter(arg0, arg1);
			 }
			}
			
		
 		System.out.println("dofilter end.....");
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
