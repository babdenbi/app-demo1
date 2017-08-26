package com.demo.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.service.IAuthenticationService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;



@Action (value ="/validate" ,results = {
		@Result (name ="success", location ="/success.jsp"),
		@Result (name ="input", location ="/authentification.jsp")
		
})


public class ValidateAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String userName;
	private String pwd; 
	
	@Autowired
	IAuthenticationService  authentificationService;
	
	@RequiredStringValidator (message = "Merci de saisir votre login")
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	@RequiredStringValidator (message = "Merci de saisir votre mot de passe")
	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	

	@Override
	public String execute () {
	
	if (authentificationService.verifier(userName, pwd)) {
		
		return SUCCESS;
	}
	
	else  {
		addActionError("Le compte saisi est invalide. Merci de réessayer !!");
		return INPUT;
	}
}

}
