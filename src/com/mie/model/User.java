package com.mie.model;

import java.util.ArrayList;

public class User {
	protected static String username;
	protected static String password;
	protected static int userType;
	private boolean valid;
	
	//admin constructor
	public User(String username, String password, int userType) {
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public int getType(){
		return userType;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setValid(boolean newValid) {
		valid = newValid;
	}
	
	public boolean isValid() {
		return valid;
	}
	public User(){
		this.userType = 0;
		
	}
	
}

