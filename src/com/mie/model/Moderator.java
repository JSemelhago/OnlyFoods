package com.mie.model;

import java.util.ArrayList;

public class Moderator extends User{
	//admin constructor
	private ArrayList<String> flaggedStudents;
	public Moderator(String username, String password) {
		super(username,password, 1);
	}
	public Moderator() {
		this.userType = 1;
	}
	public ArrayList<String> getFlaggedStudents() {
		return flaggedStudents;
	}
	public void printFlaggedStudents() {
		for (int i = 0; i < flaggedStudents.size(); i++) {
			System.out.println(flaggedStudents.get(i));
		}
	}
	public void addFlaggedStudents(String flagStu) {
		flaggedStudents.add(flagStu);
	}
	public void updateModerator() {
		String flgStr = "";
		for (int i = 0; i < flaggedStudents.size()-1; i++) {
			flgStr += flaggedStudents.get(i)+",";
		}
		flgStr += flaggedStudents.get(flaggedStudents.size() -1);
		String qStr = "UPDATE Moderator Set Password ='" + password + "',  FlaggedStudents='" + flgStr + "' WHERE Username =" + username + "; ";
				OnlyFoodsRunner.runUpdate(qStr);
	}
	
		
}
