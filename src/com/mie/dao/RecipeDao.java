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

public class RecipeDao {
	/**
	 * This class handles all of the Recipe-related methods
	 * (add/update/delete/get).
	 */

	private Connection connection;
	static Connection currentCon = null;
	static ResultSet rs = null;

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
					.prepareStatement("insert into RecipeDatabase(RecipeTitle, ImageUrl, Serving, Difficulty, PrepTime, Ingredients, Instructions, DishType, CuisineType, Username) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, recipe.getRecipeTitle());
			preparedStatement.setString(2, recipe.getImageUrl());
			preparedStatement.setInt(3, recipe.getServing());
			preparedStatement.setString(4, recipe.getDifficulty());
			preparedStatement.setDouble(5, recipe.getPrepTime());
			preparedStatement.setString(6, recipe.getIngredients());
			preparedStatement.setString(7, recipe.getInstructions());
			preparedStatement.setString(8, recipe.getDishType());
			preparedStatement.setString(9, recipe.getCuisineType());
			preparedStatement.setString(10, recipe.getUsername());
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
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update RecipeDatabase set RecipeTitle=?, ImageUrl=?, Serving=?, Difficulty=?, PrepTime=?, Ingredients=?, Instructions=?, DishType=?, CuisineType=?, Username=?"
							+ " where PostID=?");
			// Parameters start with 1
			preparedStatement.setString(1, recipe.getRecipeTitle());
			preparedStatement.setString(2, recipe.getImageUrl());
			preparedStatement.setInt(3, recipe.getServing());
			preparedStatement.setString(4, recipe.getDifficulty());
			preparedStatement.setDouble(5, recipe.getPrepTime());
			preparedStatement.setString(6, recipe.getIngredients());
			preparedStatement.setString(7, recipe.getInstructions());
			preparedStatement.setString(8, recipe.getDishType());
			preparedStatement.setString(9, recipe.getCuisineType());
			preparedStatement.setString(10, recipe.getUsername());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Recipe getRecipeById(int postId) {
		Recipe recipe = new Recipe();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from RecipeDatabase where PostID=?");
			preparedStatement.setInt(1,postId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				recipe.setPostID(rs.getInt("PostID"));
				recipe.setRecipeTitle(rs.getString("RecipeTitle"));
				recipe.setImageUrl(rs.getString("ImageUrl"));
				recipe.setServing(String.valueOf(rs.getInt("Serving")));
				recipe.setDifficulty(rs.getString("Difficulty"));
				recipe.setPrepTime(String.valueOf(rs.getInt("PrepTime")));
				recipe.setIngredients(rs.getString("Ingredients"));
				recipe.setInstructions(rs.getString("Instructions"));
				recipe.setDishType(rs.getString("DishType"));
				recipe.setCuisineType(rs.getString("CuisineType"));
				recipe.setUsername(rs.getString("Username"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return recipe;
		
	}
	public List<Recipe> getRecipeByKeyword(String keyword) {
		/**
		 * This method retrieves a list of recipes that matches the keyword
		 * entered by the user.
		 */
		List<Recipe> recipes = new ArrayList<Recipe>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from RecipeDatabase where RecipeTitle LIKE ? OR Difficulty LIKE ? OR DishType LIKE ? OR CuisineType LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			preparedStatement.setString(4, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setPostID(rs.getInt("PostID"));
				recipe.setRecipeTitle(rs.getString("RecipeTitle"));
				recipe.setImageUrl(rs.getString("ImageUrl"));
				recipe.setServing(String.valueOf(rs.getInt("Serving")));
				recipe.setDifficulty(rs.getString("Difficulty"));
				recipe.setPrepTime(String.valueOf(rs.getInt("PrepTime")));
				recipe.setIngredients(rs.getString("Ingredients"));
				recipe.setInstructions(rs.getString("Instructions"));
				recipe.setDishType(rs.getString("DishType"));
				recipe.setCuisineType(rs.getString("CuisineType"));
				recipe.setUsername(rs.getString("Username"));
				recipes.add(recipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recipes;
	}
	
	public List<Recipe> getAllRecipes(){
		List<Recipe> recipes = new ArrayList<Recipe>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from RecipeDatabase");
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setPostID(rs.getInt("PostID"));
				recipe.setRecipeTitle(rs.getString("RecipeTitle"));
				recipe.setImageUrl(rs.getString("ImageUrl"));
				recipe.setServing(String.valueOf(rs.getInt("Serving")));
				recipe.setDifficulty(rs.getString("Difficulty"));
				recipe.setPrepTime(String.valueOf(rs.getInt("PrepTime")));
				recipe.setIngredients(rs.getString("Ingredients"));
				recipe.setInstructions(rs.getString("Instructions"));
				recipe.setDishType(rs.getString("DishType"));
				recipe.setCuisineType(rs.getString("CuisineType"));
				recipe.setUsername(rs.getString("Username"));
				recipes.add(recipe);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return recipes;
	}
	
	public boolean checkUserLike(String username, int postId){
		Statement stmt = null;
		
		String searchQuery = "select * from PostEngagement where Username='" + username + "' AND PostID='" + postId + "'";
		
		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			
			if (more){
				return true;
			}
			
			else{ 
				return false;
			}
			
		} catch (Exception ex) {
			System.out.println("Like failed: An Exception has occurred! "
					+ ex);
		}
		
		return false;
	}
	
	public int addLike(String username, int postId) {
		/**
		 * This method adds a like to a recipe in the database.
		 */
		Recipe recipe = this.getRecipeById(postId);
		int updatedNumberOfLikes = recipe.getNumberOfLikes();
		try {
			PreparedStatement preparedStatement1 = connection
					.prepareStatement("insert into PostEngagement(PostID, Username) values (?, ?)");

			preparedStatement1.setInt(1, postId);
			preparedStatement1.setString(2, username);
			preparedStatement1.executeUpdate();
			
			PreparedStatement preparedStatement2 = connection
					.prepareStatement("update RecipeDatabase set NumberOfLikes=?"
							+ " where PostID=?");
	
			updatedNumberOfLikes = recipe.getNumberOfLikes() + 1;
			preparedStatement2.setInt(1, updatedNumberOfLikes);
			preparedStatement2.setInt(2, postId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updatedNumberOfLikes;
	}
	
	public int deleteLike(String username, int postId) {

		Recipe recipe = this.getRecipeById(postId);
		int updatedNumberOfLikes = recipe.getNumberOfLikes();		
		try {
			PreparedStatement preparedStatement1 = connection
					.prepareStatement("delete from PostEngagement where PostID=? AND username=?");
			preparedStatement1.setInt(1, postId);
			preparedStatement1.setString(2, username);
			preparedStatement1.executeUpdate();
		
			
			PreparedStatement preparedStatement2 = connection
					.prepareStatement("update RecipeDatabase set NumberOfLikes=?"
							+ " where PostID=?");
	
			updatedNumberOfLikes = recipe.getNumberOfLikes() - 1;
			preparedStatement2.setInt(1, updatedNumberOfLikes);
			preparedStatement2.setInt(2, postId);


		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updatedNumberOfLikes;
	}
}
