package com.slokam.as.Dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.slokam.as.pojo.studentpojo;


public class studentDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public void savedata(studentpojo std){
		
		hibernateTemplate.save(std);
	}
	
	@Transactional
	public List<studentpojo> GetallData(){
		
		return(List<studentpojo>)hibernateTemplate.find("from studentpojo");
	}
	

	@Transactional
	public studentpojo GetById(Integer id){
		
		return(studentpojo)hibernateTemplate.get(studentpojo.class,id);
	}
	
	@Transactional
	public void delete(studentpojo std){
		
		hibernateTemplate.delete(std);
	}
	
	@Transactional
	public void update(studentpojo std){
		
		hibernateTemplate.update(std);
	}
	
	
}
