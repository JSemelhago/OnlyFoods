package com.mie.model;

public class Moderator extends User{
	//admin constructor
	private ArrayList<String> flaggedStudents;
	public Moderator(String username, String password) {
		super(username,password);
	}
	public Moderator() {
		
	}
	public ArrayList<String> getFlaggedStudents() {
		return flaggedStudents;
	}
	public void printFlaggedStudents() {
		for (int i = 0; i < flaggedStudents.length; i++) {
			print(flaggedStudents.get(i));
		}
	}
	public void addFlaggedStudents(String flagStu) {
		flaggedStudents.add(flagStu);
	}
	public void updateModerator() {
		String flgStr = "";
		for (int i = 0; i < flaggedStudents.length-1; i++) {
			flgStr += flaggedStudents.get(i)+",";
		}
		flgStr += flaggedStudents.get(flaggedStudents.length-1);
		String qStr = "UPDATE Moderator Set Password ='" + password + "',  FlaggedStudents='" + flgstr + "' WHERE Username =" + username + "; ";
				OnlyFoodsRunner.runUpdate(qStr);
	}
	
		
}
