package com.slokam.web.test.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.slokam.web.test.pojo.studentpojo;

public class studentDao {
	

private HibernateTemplate hibernateTemplate;

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}
@Transactional
public void saveStudent(studentpojo std){
	hibernateTemplate.save(std);
	
}
@Transactional
public List<studentpojo> GetallStudent(){
	return (List<studentpojo>)hibernateTemplate.find("from studentpojo");
}
@Transactional
public studentpojo getStudentById(Integer id){
	
	return (studentpojo)hibernateTemplate.get(studentpojo.class, id);
	
	}
@Transactional
public void Updatestudent(studentpojo std){
	hibernateTemplate.update(std);
	
}

@Transactional
public void Deletestudent(studentpojo std){
	hibernateTemplate.delete(std);
	
}

public boolean 	CheckStudentByName(String name){
	List<studentpojo> students=(List<studentpojo>)hibernateTemplate.find("from studentpojo where name=?", name);
	
	if(students.size()==0){
		return true;
	}else{
		return false;
	}
	
}
}
