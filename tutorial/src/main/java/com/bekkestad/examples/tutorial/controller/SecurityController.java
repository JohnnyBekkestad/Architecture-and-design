package com.bekkestad.examples.tutorial.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.bekkestad.examples.tutorial.model.Credentials;
import com.bekkestad.examples.tutorial.model.UserDAO;
import com.bekkestad.examples.tutorial.service.UserServiceImpl;

@Named
@SessionScoped
public class SecurityController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_MESSAGE = "Welcome";
	private static final String FAILURE_MESSAGE = "Incorrect username and/or password";
	
	private UserDAO currentUser;
	
	@Inject
	private Credentials credentials;
	
	@Inject 
	private UserServiceImpl userService;
	
	public String login(){
		
		String nextState = "home.xhtml";		
		if(!isLoggedIn()){
			try {
												
				currentUser = userService.loginUser(credentials.getUsername(), credentials.getPassword());				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SUCCESS_MESSAGE));		
				
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_WARN, FAILURE_MESSAGE, FAILURE_MESSAGE));				
				nextState = "login.xhtml";
			}			
		}		
		return nextState;
	}
	
	public boolean isLoggedIn(){
		return currentUser != null;
	}
	
	@Produces
	@Named
	public UserDAO getCurrentUser(){
		return currentUser;
	}
}
