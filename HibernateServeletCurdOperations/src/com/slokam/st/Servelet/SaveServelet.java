package com.slokam.st.Servelet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.slokam.st.Dao.StudentDao;
import com.slokam.st.pojo.studentpojo;

public class SaveServelet extends GenericServlet{

	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
	String name=req.getParameter("name");
	String age=req.getParameter("age");
	String phone=req.getParameter("phone");
	String qual=req.getParameter("qual");
	
	studentpojo student=new studentpojo();
	student.setName(name);
	student.setAge(age);
	student.setPhone(phone);
	student.setQual(qual);
	
	StudentDao data=new StudentDao();
	data.savestudent(student);
	
	req.setAttribute("message", "sucessfully saved");
	req.getRequestDispatcher("student.jsp").forward(req, res);
		
	}

}
