package com.mie.model;

import java.util.ArrayList;

public class Student extends User{
	private String name;
	private String email;
	private String bio;
	private String location;
	private String photoUrl;
	private boolean valid;
	private ArrayList<Recipe> savedPost;
	
	public Student(String username, String password, String name, String email) {
		super(username, password);
		this.name = name;
		this.email = email;
	}
	
	
	public Student(String username, String password, String name, String email, String bio, String location, String photoUrl) {
		super(username, password);
		this.name = name;
		this.email = email;
		this.bio = bio;
		this.location = location;
		this.photoUrl = photoUrl;
	}
	
	public Student(){
		
	}
	
	
	
	
	//getters
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getBio(){
		return bio;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getPhotoUrl(){
		return photoUrl;
	}
	
	//setters

	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBio(String bio){
		this.bio = bio;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public void setValid(boolean newValid) {
		valid = newValid;
	}
	
	//Methods
	public boolean isValid() {
		return valid;
	}
	
	public void addSavedRecipe(Recipe post) {
		savedPost.add(post);
	}
	
	public void removeSavedRecipe(Recipe post) {
		savedPost.remove(post);
	}
	
	public void updateStudent() {
		String qStr = "UPDATE Student Set Email ='" + email + "', Name ='" + name + "', PhotoUrl = '"
				+ photoUrl + "', Bio = '" + bio +  "', Location = '" + location +  "', Password = '" + password + "' WHERE Username =" + username + "; ";
				OnlyFoodsRunner.runUpdate(qStr);
	}
	
	public void updateUserRecords() {
		String qStr = "UPDATE UserRecords Set Password ='" + password + "' WHERE Username =" + username + "; ";
			OnlyFoodsRunner.runUpdate(qStr);
	}
}
