package com.slokam.web.test.Dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.slokam.web.test.pojo.UserDetailsImpl;

public class UserDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public UserDetailsImpl getUserDetailsByName(String username){
		System.out.println(username);
		 List<UserDetailsImpl> users=(List<UserDetailsImpl>)hibernateTemplate.find("from UserDetailsImpl where username=?",username);
		/*for (UserDetailsImpl u:users) {
			System.out.println(u.getUsername());
			System.out.println(u.getPassword());
			System.out.println(u.getUid());
		}
		 System.out.println(users.get(0));*/
		 if(users.size()>0){
			 System.out.println("users");
			return users.get(0);
		}else{
			return null;
		}
	}
}
