package com.slokam.sc.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.slokam.sc.pojo.billpojo;
import com.slokam.sc.pojo.sellerpojo;


public class SellerDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public void SellerSave(sellerpojo seller){
		
		hibernateTemplate.save(seller);
	}
	@Transactional
	public List<sellerpojo> getallseller(){
		
	return (List<sellerpojo>)	hibernateTemplate.find("from sellerpojo");
			
	}
	//buyer
	@Transactional
	public sellerpojo getsellerById(Integer id){
		
	return(sellerpojo)	hibernateTemplate.get(sellerpojo.class, id);
		
	}
	//buyer
	@Transactional
	public billpojo getBuyuyerById(Integer id){
		
		return(billpojo)hibernateTemplate.get(billpojo.class, id);
			
		}
	//bill
	@Transactional
	public void billsave(billpojo bill){
		
		hibernateTemplate.save(bill);
	}
	//buyer
	@Transactional
	public List<billpojo> getbill(){
		
		return(List<billpojo>)hibernateTemplate.find("from billpojo");
	}
	@Transactional
	public void Updateseller(sellerpojo seller){
		hibernateTemplate.update(seller);
		
	}

	@Transactional
	public void Deleteseller(sellerpojo seller){
		hibernateTemplate.delete(seller);
		
	}
	//buyer
	@Transactional
	public void Updateorder(billpojo bill){
		hibernateTemplate.update(bill);
		
	}
//buyer
	@Transactional
	public void Deleteorder(billpojo bill){
		hibernateTemplate.delete(bill);
		
	}
	
	
}
