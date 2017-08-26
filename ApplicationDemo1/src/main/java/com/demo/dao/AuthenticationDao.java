package com.demo.dao;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class AuthenticationDao implements IAutehnticationDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	

	@Override
	public Number check(String userName, String pwd) {
		
		List countList =   hibernateTemplate.find 
				(" SELECT a.id FROM User a WHERE a.userName = userName and a.pwd = pwd");
		
	   Number count = countList.size();
	   
	   return count;
		
	    }
	    
		}
	


