package com.bekkestad.examples.tutorial.service;

import java.util.List;

import com.bekkestad.examples.tutorial.model.UserDAO;

public interface UserService {

	void addUser(UserDAO user);
	
	void updateUser(UserDAO user);
	
	void removeUser(UserDAO user);
	
	UserDAO getUser(String username) throws Exception;
	
	UserDAO loginUser(String username, String password);
	
	List<UserDAO> getUsers();
}
