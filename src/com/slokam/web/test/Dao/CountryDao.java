package com.slokam.web.test.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.slokam.web.test.pojo.Countrypojo;
import com.slokam.web.test.pojo.StatePojo;

@Repository
public class CountryDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	public List<Countrypojo> getAllCountrys(){
		return (List<Countrypojo>)	hibernateTemplate.find("from Countrypojo");
		
		
	}
	
	public List<StatePojo> getStatesById(Integer cid){
		return (List<StatePojo>)hibernateTemplate.find("select s from StatePojo s join s.country c where c.id=?", cid);
		
	}
}
