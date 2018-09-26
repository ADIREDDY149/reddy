package com.slokam.st.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.slokam.st.pojo.studentpojo;

public class StudentDao {

	public void savestudent(studentpojo std) {
		
		
		AnnotationConfiguration config=new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		SessionFactory sf=config.buildSessionFactory();
		Session s=sf.openSession();
		
		Transaction t=s.beginTransaction();
		
		studentpojo st=new studentpojo();
		st.setName(std.getName());
		st.setId(std.getId());
		st.setAge(std.getAge());
		st.setPhone(std.getPhone());
		st.setQual(std.getQual());
		s.save(st);
		t.commit();
		
		s.close();
	}

}
