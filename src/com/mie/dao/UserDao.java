package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public static User login(Student student) {

		/**
		 * This method attempts to find the member that is trying to log in by
		 * first retrieving the username and password entered by the user.
		 */
		Statement stmt = null;

		String username = student.getUsername();
		String password = student.getPassword();

		/**
		 * Prepare a query that searches the members table in the database
		 * with the given username and password.
		 */
		String searchQuery = "select * from UserRecords where Username='"
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
				student.setValid(false);
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
				

				student.setName(name);
				student.setEmail(email);
				student.setBio(bio);
				student.setLocation(location);
				student.setPhotoUrl(photoUrl);
				student.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		/**
		 * Return the User object.
		 */
		return student;

	}
}


