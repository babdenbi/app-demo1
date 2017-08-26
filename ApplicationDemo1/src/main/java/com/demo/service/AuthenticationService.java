package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.IAutehnticationDao;
import com.demo.model.User;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	IAutehnticationDao authenticationDao;
	@Autowired
	User user;
	
	
	@Override
	@Transactional 
	public boolean verifier(String userName, String pwd) {
	user.setUserName(userName);
	user.setPwd(pwd);
	String login = user.getUserName();
	String motDePasse = user.getPwd();
	Integer count  = authenticationDao.check(login, motDePasse).intValue();
	
	boolean b = (count == 0) ? false : true;
	
	return b ;
			
			
			
	}

}
