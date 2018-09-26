package com.slokam.as.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.slokam.as.Dao.studentDao;
import com.slokam.as.pojo.studentpojo;

public class studentservice {

	private studentDao studentdao;
	
	public void setStudentdao(studentDao studentdao) {
		this.studentdao = studentdao;
	}



	public void savedata(studentpojo std){
		studentdao.savedata(std);
		
	}
	@Transactional
	public List<studentpojo> GetallData(){
		return studentdao.GetallData();
	}
	
	public studentpojo GetById(Integer id){
		return studentdao.GetById(id);
		
	}
	public void delete(studentpojo std){
		studentdao.delete(std);
		
	}
	
	public void update(studentpojo std){
		studentdao.update(std);
		
	}
	
}
