package com.bekkestad.examples.tutorial.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import com.bekkestad.examples.tutorial.model.UserDAO;
import com.bekkestad.examples.tutorial.repository.UserRepository;

@SessionScoped
public class UserServiceImpl implements UserService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserRepository users;
	
	public void addUser(UserDAO user){
		users.addUser(user);
	}
	
	public void updateUser(UserDAO user){
		users.updateUser(user);
	}
	
	public void removeUser(UserDAO user){
		users.deleteUser(user);
	}
	
	public UserDAO getUser(String username) throws Exception{
		return users.getUser(username);
	}
	
	public UserDAO loginUser(String username, String password){
		return users.getUser(username, password);
	}
	
	public List<UserDAO> getUsers(){
		return users.getAllUsers();
	}

}
