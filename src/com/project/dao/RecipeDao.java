package com.project.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mie.model.Student;
import com.mie.util.DbUtil;

import com.project.model.*;

public class RecipeDao {
	/**
	 * This class handles all of the Student-related methods
	 * (add/update/delete/get).
	 */

	private Connection connection;

	public RecipeDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}

	public void addRecipe(Recipe recipe) {
		/**
		 * This method adds a new recipe to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into RecipeDatabase(PostID, RecipeTitle, ImageUrl, Serving, Difficulty, PrepTime, Ingredients, Instructions, DishType, CuisineType, Username) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setInt(1, recipe.getPostID());
			preparedStatement.setString(2, recipe.getRecipeTitle());
			preparedStatement.setString(3, recipe.getImageUrl());
			preparedStatement.setInt(4, recipe.getServing());
			preparedStatement.setString(5, recipe.getDifficulty());
			preparedStatement.setDouble(6, recipe.getPrepTime());
			preparedStatement.setString(7, recipe.getIngredients());
			preparedStatement.setString(8, recipe.getInstructions());
			preparedStatement.setString(9, recipe.getDishType());
			preparedStatement.setString(10, recipe.getCuisineType());
			preparedStatement.setString(11, recipe.getUsername());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteRecipe(int postid) {
		/**
		 * This method deletes a recipe post from the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from RecipeDatabase where PostID=?");
			// Parameters start with 1
			preparedStatement.setInt(1, postid);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateRecipe(Recipe recipe) {
		/**
		 * This method updates a recipe's information into the database.
		 */
		
		//TODO: This is literally copy-and-pasted from the example
		
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("update students set firstname=?, lastname=?, dob=?, email=?"
//							+ " where studentid=?");
//			// Parameters start with 1
//			preparedStatement.setString(1, student.getFirstName());
//			preparedStatement.setString(2, student.getLastName());
//			preparedStatement.setDate(3, new java.sql.Date(student.getDob()
//					.getTime()));
//			preparedStatement.setString(4, student.getEmail());
//			preparedStatement.setInt(5, student.getStudentid());
//			preparedStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public List<Student> getAllStudents() {
		/**
		 * This method returns the list of all students in the form of a List
		 * object.
		 */
		List<Student> students = new ArrayList<Student>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting students from table");
			ResultSet rs = statement.executeQuery("select * from students");
			while (rs.next()) {
				Student student = new Student();
				student.setStudentid(rs.getInt("studentid"));
				student.setFirstName(rs.getString("firstname"));
				student.setLastName(rs.getString("lastname"));
				student.setDob(rs.getDate("dob"));
				student.setEmail(rs.getString("email"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	public Student getStudentById(int studentid) {
		/**
		 * This method retrieves a student by their StudentID number.
		 * 
		 * Currently not used in the sample web app, but code is left here for
		 * your review.
		 */
		Student student = new Student();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from students where studentid=?");
			preparedStatement.setInt(1, studentid);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				student.setStudentid(rs.getInt("studentid"));
				student.setFirstName(rs.getString("firstname"));
				student.setLastName(rs.getString("lastname"));
				student.setDob(rs.getDate("dob"));
				student.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}

	public List<Student> getStudentByKeyword(String keyword) {
		/**
		 * This method retrieves a list of students that matches the keyword
		 * entered by the user.
		 */
		List<Student> students = new ArrayList<Student>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from students where firstname LIKE ? OR lastname LIKE ? OR email LIKE ? OR dob LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			preparedStatement.setString(4, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentid(rs.getInt("studentid"));
				student.setFirstName(rs.getString("firstname"));
				student.setLastName(rs.getString("lastname"));
				student.setDob(rs.getDate("dob"));
				student.setEmail(rs.getString("email"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

}
