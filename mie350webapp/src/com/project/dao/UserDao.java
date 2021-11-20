package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.util.DbUtil;
import com.project.model.*;
import com.project.controller.*;

import com.project.dao.util.*;

public class UserDao {

	/**
	 * This class handles the Member objects and the login component of the web
	 * app.
	 */
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static User login(User user) {

		/**
		 * This method attempts to find the member that is trying to log in by
		 * first retrieving the username and password entered by the user.
		 */
		Statement stmt = null;

		String username = user.getUsername();
		String password = user.getPassword();

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
				

				user.setName(name);
				user.setEmail(email);
				user.setBio(bio);
				user.setLocation(location);
				user.setPhotoUrl(photoUrl);
				user.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		/**
		 * Return the User object.
		 */
		return user;

	}
}


