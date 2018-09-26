package com.slokam.web.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.slokam.web.comparator.AgeComparator;
import com.slokam.web.comparator.PhoneComparator;
import com.slokam.web.comparator.QualComparator;
import com.slokam.web.comparator.StudentNameComparator;
import com.slokam.web.test.Service.CountryService;
import com.slokam.web.test.Service.studentService;
import com.slokam.web.test.pojo.Countrypojo;
import com.slokam.web.test.pojo.StatePojo;
import com.slokam.web.test.pojo.loginpojo;
import com.slokam.web.test.pojo.studentpojo;

@Controller
public class TestController1 {
	@Autowired	
	private CountryService countryService;
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private studentService studentservice;
	
	@RequestMapping("test")
	public ModelAndView test(HttpSession session){
		ModelAndView mv=new ModelAndView();
		System.out.println(" iam in test controller");
		/*Random random=new Random();
		int otp=random.nextInt();
		session.setAttribute("otp", otp);
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo("ksadi143@gmail.com");
		message.setFrom("adi.ecea@gmail.com");
		message.setSubject("this otp is::");
		mailSender.send(message);*/
		mv.addObject("student", new studentpojo());
		mv.setViewName("login.jsp");
		
		
return mv;
	}
	
	//this spring one of the method approach
	/*@RequestMapping("login")
	public String login(String username,String password){
		System.out.println("username is::"+username);
		System.out.println("password is:;"+password);
		System.out.println(" iam in login controller");
return "student.jsp";
	}*/
	//this spring model and view concept
	@RequestMapping("login")
	public ModelAndView login(loginpojo login,HttpSession session){
		ModelAndView mv=new ModelAndView();
		if(login.getUsername().equals(login.getPassword()))
		{
			/*Random random=new Random();
			int otp=random.nextInt();
			session.setAttribute("otp", otp);
			
			SimpleMailMessage message=new SimpleMailMessage();
			message.setTo("ksadi143@gmail.com");
			message.setFrom("adi.ecea@gmail.com");
			message.setSubject("this otp is::");
			mailSender.send(message);*/
			mv.addObject("student", new studentpojo());
			mv.setViewName("student.jsp");
		}
		else{
		
		mv.setViewName("login.jsp");
		System.out.println(" iam in login controller");
		}
		return mv;
	}
	/*@RequestMapping("student")
	public String displaystudents(){
		System.out.println("i am in displaystudent controller");
		return "student.jsp";
		
	}*/
	//this spring model and view concept
	@RequestMapping("student1")
	public ModelAndView displaystudents(HttpSession session){
		System.out.println("am at student...");
		ModelAndView mv=new ModelAndView();
		mv.addObject("student", new studentpojo());
		Random random=new Random();
		int otp=random.nextInt();
		session.setAttribute("otp", otp);
		System.out.println("My otp is::"+otp);
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo("ksadi143@gmail.com");
		message.setFrom("adi.ecea@gmail.com");
		
		message.setSubject("this otp is::"+otp);
		
		message.setText("your otp is::");
		mailSender.send(message);
		mv.setViewName("otp.jsp");
		System.out.println("i am in displaystudent controller");
		return mv;
		
	}
	/*@RequestMapping("savestudent")
	public String savestudent(studentpojo std){
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getQual());
		System.out.println(std.getPhone());
		
		studentservice.savestudent(std);
		
		return "student.jsp";
		}*/
	//this spring model and view concept
	@Secured({"ROLE_USER","ROLE_ADMIN","ROLE_MANAGER"})
	@RequestMapping("savestudent")
	public ModelAndView savestudent(studentpojo std){
		ModelAndView mv=new ModelAndView();
		mv.addObject("student", new studentpojo());
		List<Countrypojo> countries=countryService.getAllCountrys();
		mv.addObject("countries", countries);
		mv.setViewName("student.jsp");
		System.out.println(std.getFileData().getOriginalFilename());
		MultipartFile mpf=std.getFileData();
				File f=new File("E:\\uploads\\"+mpf.getOriginalFilename());
				try {
					mpf.transferTo(f);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getQual());
		System.out.println(std.getPhone());
		
		studentservice.savestudent(std);
		
		return mv;
		}
	/*@RequestMapping("getallstudent")
	public String getallstudents(HttpServletRequest req){
		
		List<studentpojo> students=studentservice.GetallStudent();
		
		req.setAttribute("students", students);
		return "student.jsp";
	}*/
	//this mvc
	//@Secured({"ROLE_MANAGER","ROLE_ADMIN"})

	@RequestMapping("getallstudent")
	public ModelAndView getallstudents(String sort){
		
		ModelAndView mv=new ModelAndView();
		List<studentpojo> students=studentservice.GetallStudent();
		List<Countrypojo> countries=countryService.getAllCountrys();
		mv.addObject("countries", countries);
		if(sort!=null){
			switch(sort){

			case"name":Collections.sort(students, new StudentNameComparator());break; 
			case"age":Collections.sort(students, new AgeComparator());break; 
			case"qual":Collections.sort(students, new QualComparator());break; 
			case"phone":Collections.sort(students, new PhoneComparator());break; 
			}
		}
		mv.addObject("students", students);
		mv.addObject("student", new studentpojo());
		mv.setViewName("student.jsp");
		return mv;
	}
	/*@RequestMapping("getstudentById")
	public String getstudentById(Integer id,HttpServletRequest request){
	
		studentpojo student=studentservice.getStudentById(id);
		request.setAttribute("student", student);
		return "student.jsp";
		
	}*/
	@RequestMapping("getstudentById")
	public ModelAndView getstudentById(Integer id,HttpSession session){
		ModelAndView mv=new ModelAndView();
		studentpojo student=studentservice.getStudentById(id);
		session.setAttribute("preData", student);
		
		List<Countrypojo> countries=countryService.getAllCountrys();
		mv.addObject("countries", countries);
		mv.addObject("student", student);
		mv.setViewName("student.jsp");
		return mv;
		
	}
	/*@RequestMapping("Updatestudent")
	public String updatestudent(studentpojo std){
		
		studentservice.Updatestudent(std);
		return "student.jsp";
		
	}*/
	
	@RequestMapping("Updatestudent")
	public ModelAndView updatestudent(studentpojo std,HttpSession session){
		ModelAndView mv=new ModelAndView();
		studentservice.Updatestudent(std,session);
		List<Countrypojo> countries=countryService.getAllCountrys();
		mv.addObject("countries", countries);
		mv.addObject("student", new studentpojo());
		mv.setViewName("student.jsp");
		return mv;
		
	}
	/*@RequestMapping("Deletestudent")
	public String Deletestudent(studentpojo std){
		
		studentservice.Deletestudent(std);
		return "student.jsp";
		
	}*/
	@RequestMapping("Deletestudent")
	public ModelAndView Deletestudent(studentpojo std){
		ModelAndView mv=new ModelAndView();
		studentservice.Deletestudent(std);
		List<Countrypojo> countries=countryService.getAllCountrys();
		mv.addObject("countries", countries);
		mv.addObject("student", new studentpojo());
		mv.setViewName("student.jsp");
		return mv;
		
	}
	@RequestMapping("CheckStudentByName")
	public ModelAndView	CheckStudentByName(studentpojo student){
		
		boolean result=studentservice.CheckStudentByName(student.getName());
		String message="";
		if(!result){
			 message="Name Already existed,Try another.";
		}else
		{
			 message="Name Not existed,No Problem.";
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("student.jsp");
		mv.addObject("student", student);
		mv.addObject("message", message);
		return mv;
	}
	
	@RequestMapping("getStates")
	public ModelAndView getAllStates(studentpojo student){
		ModelAndView mv=new ModelAndView();
		mv.addObject("student",student);
		List<Countrypojo> countries=countryService.getAllCountrys();
		mv.addObject("countries", countries);
		mv.setViewName("student.jsp");
		
		List<StatePojo> stateslist=countryService.getStatesById(student.getSelectedCountry());
		mv.addObject("states", stateslist);
		return mv;
		
	}
	@RequestMapping("CheckStudentByNameAsync")
	public void	CheckStudentByNameAsync(String name,HttpServletResponse resp) throws IOException{
		boolean result=studentservice.CheckStudentByName(name);
		String message="";
		if(!result){
			 message="Name Already existed,Try another.";
		}else
		{
			 message="Name Not existed,No Problem.";
		}
		PrintWriter pw=resp.getWriter();
		pw.print(message);
	}
}
