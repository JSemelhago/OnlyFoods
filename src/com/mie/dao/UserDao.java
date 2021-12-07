package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Recipe;
import com.mie.model.User;
import com.mie.util.DbUtil;
import com.mie.model.*;
import com.mie.controller.*;


public class UserDao {

	/**
	 * This class handles the Member objects and the login component of the web
	 * app.
	 */
	static Connection currentCon = null;
	static ResultSet rs = null;
	private Connection connection;
	
	public UserDao(){
		connection = DbUtil.getConnection();
	}
	
	public static boolean checkIfExists(String uname){
		
		
		Statement stmt = null;
		String searchQuery = "SELECT Username FROM Student;";
		
		
		try{
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			
			while (rs.next()){
				if (rs.getString(1).equals(uname)){
					return true;
				}
			}
		}catch (Exception ex){
			System.out.println(ex);
		}
		
		return false;
		
	}
	
	public static boolean checkIfModerator(String uname){
		
		
		Statement stmt = null;
		String searchQuery = "SELECT Username FROM Moderator;";
		
		
		try{
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			
			while (rs.next()){
				if (rs.getString(1).equals(uname)){
					return true;
				}
			}
		}catch (Exception ex){
			System.out.println(ex);
		}
		
		return false;
		
		
	}
	
	public static boolean checkUserType(User user){

		/**
		 * This method attempts to find the member that is trying to log in by
		 * first retrieving the username and password entered by the user.
		 */
		Statement stmt = null;

		String username = user.getUsername();
		String password = user.getPassword();
		
		/**
		 * Prepare a query that searches the users table in the database
		 * with the given username and password.
		 */
		String searchQuery = "select Moderator_YN from User where Username='"
				+ username + "' AND Password='" + password + "'";

		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			int userType = rs.getInt("Moderator_YN");
			
			if (more && userType == 1){
				return true;
			}
			
			else{ 
				return false;
			}
			
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		
		return false;
	}
	
	public static Moderator moderatorLogin(User user) {

		/**
		 * This method attempts to find the moderator that is trying to log in by
		 * first retrieving the username and password entered by the user.
		 */
		Statement stmt = null;

		String username = user.getUsername();
		String password = user.getPassword();
		Moderator moderator = new Moderator();
		
		/**
		 * Prepare a query that searches the moderator table in the database
		 * with the given username and password.
		 */
		String searchQuery = "select * from Moderator where Username='"
				+ username + "' AND Password='" + password + "'";

		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			/**
			 * If there are no results from the query, set the user to false.
			 * The person attempting to log in will be redirected to the home
			 * page when isValid is false.
			 */
			
			if (!more) {
				moderator.setValid(false);
			}

			/**
			 * If the query results in an database entry that matches the
			 * username and password, assign the appropriate information to
			 * the User object.
			 */
			else if (more) {
				moderator.setUsername(username);
				moderator.setPassword(password);
				moderator.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		
		/**
		 * Return the Moderator object.
		 */
		
		return moderator;
	}

	public static Student studentLogin(User user) {

		/**
		 * This method attempts to find the member that is trying to log in by
		 * first retrieving the username and password entered by the user.
		 */
		Statement stmt = null;

		String username = user.getUsername();
		String password = user.getPassword();
		Student student = new Student();
		
		/**
		 * Prepare a query that searches the members table in the database
		 * with the given username and password.
		 */
		String searchQuery = "select * from Student where Username='"
				+ username + "' AND Password='" + password + "'";

		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			/**
			 * If there are no results from the query, set the user to false.
			 * The person attempting to log in will be redirected to the home
			 * page when isValid is false.
			 */
			
			if (!more) {
				user.setValid(false);
			}

			/**
			 * If the query results in an database entry that matches the
			 * username and password, assign the appropriate information to
			 * the User object.
			 */
			else if (more) {
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				String bio = rs.getString("Bio");
				String location = rs.getString("Location");
				String photoUrl = rs.getString("PhotoUrl");
				
				student.setUsername(username);
				student.setPassword(password);
				student.setName(name);
				student.setEmail(email);
				student.setBio(bio);
				student.setLocation(location);
				student.setPhotoUrl(photoUrl);
				student.setValid(true);
				user.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		
		/**
		 * Return the Student object.
		 */
		return student;

	}
	
	public boolean addStudent(Student student) {
		/**
		 * This method adds a new student to the database.
		 */
		
		try {
			PreparedStatement preparedStatement1 = connection.prepareStatement("insert into User(Username, Password, Moderator_YN) values (?, ?, ?)");
			preparedStatement1.setString(1, student.getUsername());
			preparedStatement1.setString(2, student.getPassword());
			preparedStatement1.setInt(3, 0);
			preparedStatement1.executeUpdate();
			
			preparedStatement1 = connection.prepareStatement("insert into Student(Username, Email, Name, PhotoUrl, Bio, Location, Password) values (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement1.setString(1, student.getUsername());
			preparedStatement1.setString(2, student.getEmail());
			preparedStatement1.setString(3, student.getName());
			preparedStatement1.setString(4, student.getPhotoUrl());
			preparedStatement1.setString(5, student.getBio());
			preparedStatement1.setString(6, student.getLocation());
			preparedStatement1.setString(7, student.getPassword());
			preparedStatement1.executeUpdate();
			
//			if (insertedRow1 > 0){
//				PreparedStatement preparedStatement2 = connection.prepareStatement("insert into Student(Username, Email, Name, PhotoUrl, Bio, Location, Password)) values (?, ?, ?, ?, ?, ?, ?)");
//				preparedStatement2.setString(1, student.getUsername());
//				preparedStatement2.setString(2, student.getEmail());
//				preparedStatement2.setString(3, student.getName());
//				preparedStatement2.setString(4, student.getPhotoUrl());
//				preparedStatement2.setString(5, student.getBio());
//				preparedStatement2.setString(6, student.getLocation());
//				preparedStatement2.setString(7, student.getPassword());
//				int insertedRow2 = preparedStatement2.executeUpdate();
//				
//				if(insertedRow2 <= 0 ){
//					currentCon.rollback();
//					return false;
//				}
//				
//				return true;
//			}
//			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;	
	}
}
