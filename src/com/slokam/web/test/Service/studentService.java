package com.slokam.web.test.Service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.slokam.web.test.Dao.AuditDao;
import com.slokam.web.test.Dao.studentDao;
import com.slokam.web.test.pojo.AuditPojo;
import com.slokam.web.test.pojo.studentpojo;
import com.slokam.web.util.AuditUtil;

public class studentService {
	
private studentDao studentdao;

private AuditUtil auditUtil;
public void setAuditUtil(AuditUtil auditUtil) {
	this.auditUtil = auditUtil;
}
private AuditDao auditDao;

public void setAuditDao(AuditDao auditDao) {
	this.auditDao = auditDao;
}
public void setStudentdao(studentDao studentdao) {
	this.studentdao = studentdao;
}
	public void savestudent(studentpojo std){
		studentdao.saveStudent(std);
		}
	
	public List<studentpojo> GetallStudent(){
		return studentdao.GetallStudent();
	}
	
	public studentpojo getStudentById(Integer id){
		
		return studentdao.getStudentById(id);
		
	}
	@Transactional
	public void Updatestudent(studentpojo student,HttpSession session){

		studentpojo preStudent =(studentpojo)session.getAttribute("preData");
		//AuditUtil a=new AuditUtil();
		auditUtil.audit(preStudent, student);
		/*AuditPojo audit=new AuditPojo();
		
		 predata =(studentpojo)session.getAttribute("preData");
		
		if(!predata.getAge().equals(student.getAge())){
			
			
		String userName=SecurityContextHolder.getContext().getAuthentication().getName();
		audit.setClassName("Student");
		audit.setCurrentValue(student.getAge()+"");
		audit.setPreValue(predata.getAge()+"");
		audit.setPropertyName("age");
		audit.setHappendAt(new Date());
		audit.setUid(userName);
		auditDao.saveAudit(audit);
		}*/
		studentdao.Updatestudent(student);
	}
	@Transactional
	public void Deletestudent(studentpojo std){
		
		studentdao.Deletestudent(std);
		
	}
	public boolean 	CheckStudentByName(String name){
		return studentdao.CheckStudentByName(name);
	}
}
