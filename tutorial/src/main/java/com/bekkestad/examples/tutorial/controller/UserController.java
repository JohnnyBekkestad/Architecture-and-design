package com.bekkestad.examples.tutorial.controller;

public class UserController {
	
	public void log(String name){
		System.out.println(createLog(name));
	}
	
	public String createLog(String name){
		return name + " has logged in!";
	}

}
