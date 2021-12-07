package com.mie.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.RecipeDao;
import com.mie.dao.UserDao;
import com.mie.model.Moderator;
import com.mie.model.Recipe;
import com.mie.model.Student;
import com.mie.model.User;

import javax.servlet.http.HttpSession;

public class PostEngagementController {
	
	RecipeDao dao = new RecipeDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		 
		HttpSession session = request.getSession();
		 
		/**
		 * Retrieve the entered username and postid from the listRecipePublic.jsp form.
		 */
		
		String username = (String) session.getAttribute("username");
		int postId = Integer.parseInt(request.getParameter("postid"));
		Recipe recipe = dao.getRecipeById(postId);

		try {
			
			if (dao.checkUserLike(username, postId)){
				int updatedNumberOfLikes = dao.deleteLike(username, postId);
				if (recipe.getNumberOfLikes() != updatedNumberOfLikes){
					recipe.setNumberOfLikes(updatedNumberOfLikes);
				}
				else{
					System.out.println("Unlike: Error Updating");
				}
			}
			
			else{
				int updatedNumberOfLikes = dao.addLike(username, postId);
				if (recipe.getNumberOfLikes() != updatedNumberOfLikes){
					recipe.setNumberOfLikes(updatedNumberOfLikes);
				}
				else{
					System.out.println("Like: Error Updating");
				}
			}
			
			// should automatically update since it will reload page:) just need an if statement on whether which to return
			response.sendRedirect("listRecipePublic.jsp");
		}

		catch (Throwable theException) {
			/**
			 * Print out any errors.
			 */
			System.out.println(theException);
		}
	}
	/* Hello Anita! I'm dying:$ */

}
