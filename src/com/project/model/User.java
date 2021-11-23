package com.project.model;

import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private String name;
	private String email;
	private String bio;
	private String location;
	private String photoUrl;
	private boolean valid;
	private ArrayList<Recipe> savedPost;
	
	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public User() {
		
	}
	
	
	public User(String username, String password, String name, String email, String bio, String location, String photoUrl) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.bio = bio;
		this.location = location;
		this.photoUrl = photoUrl;
	}
	
	
	//admin constructor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//getters
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
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
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
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
		this.valid = newValid;
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
	
	public void updateUserRecords() {
		String qStr = "UPDATE UserRecords Set Email ='" + email + "', Name ='" + name + "', PhotoUrl = '"
				+ photoUrl + "', Bio = '" + bio +  "', Location = '" + location +  "', SavedPost = '" + savedPost + "' WHERE Username =" + username + "; ";
		OnlyFoodsRunner.runUpdate(qStr);
	}
	
	public void updateUserCredentials() {
		String qStr = "UPDATE UserCredentials Set Password ='" + password + "' WHERE Username =" + username + "; ";
		OnlyFoodsRunner.runUpdate(qStr);
	}
	
}
