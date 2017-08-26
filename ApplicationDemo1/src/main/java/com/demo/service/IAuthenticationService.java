package com.demo.service;

import org.springframework.stereotype.Service;


public interface IAuthenticationService {
	
  boolean verifier (String userName, String pwd);

}
