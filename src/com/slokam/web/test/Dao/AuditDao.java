package com.slokam.web.test.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slokam.web.test.pojo.AuditPojo;

public class AuditDao {

	
	
	private HibernateTemplate hibernateTemplate;
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

@Transactional
	public void saveAudit(AuditPojo audit){
		
		hibernateTemplate.save(audit);
		
	}
}
