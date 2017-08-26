package com.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name ="T_USER")
public class User implements Serializable{
	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	@Column (name = "login")
	private String userName;
	@Column (name = "motDePasse")
	private String pwd;
	@Id
	private Integer id;
	
	public User () {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
}
