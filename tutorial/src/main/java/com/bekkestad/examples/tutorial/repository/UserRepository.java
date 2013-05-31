package com.bekkestad.examples.tutorial.repository;

import java.util.List;

import javax.ejb.Local;

import com.bekkestad.examples.tutorial.model.UserDAO;

@Local
public interface UserRepository {

	List<UserDAO> getAllUsers();
	UserDAO getUser(String username);	
	UserDAO getUser(String username, String password);
	Long addUser(UserDAO user);
	void updateUser(UserDAO user);
	void deleteUser(UserDAO user);
}
