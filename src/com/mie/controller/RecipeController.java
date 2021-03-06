package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.RecipeDao;
import com.mie.model.Recipe;
import com.mie.model.Student;

public class RecipeController extends HttpServlet {
	/**
	 * This class handles all insert/edit/list functions of the servlet.
	 * 
	 * These are variables that lead to the appropriate JSP pages. INSERT leads
	 * to the Add A Student page. EDIT leads to the Edit A Student page.
	 * LIST_STUDENT_PUBLIC leads to the public listing of students.
	 * LIST_STUDENT_ADMIN leads to the admin-only listing of students (for them
	 * to modify student information).
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/addRecipe.jsp";
	private static String EDIT = "/editRecipe.jsp";
	private static String LIST_RECIPE_PUBLIC = "/listRecipePublic.jsp";
	//private static String LIST_STUDENT_ADMIN = "/listRecipeAdmin.jsp";

	private RecipeDao dao;

	/**
	 * Constructor for this class.
	 */
	public RecipeController() {
		super();
		dao = new RecipeDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This class retrieves the appropriate 'action' found on the JSP pages:
		 * 
		 * - delete will direct the servlet to let the user delete a student in
		 * the database. - insert will direct the servlet to let the user add a
		 * new student to the database. - edit will direct the servlet to let
		 * the user edit student information in the database. - listStudent will
		 * direct the servlet to the public listing of all students in the
		 * database. - listStudentAdmin will direct the servlet to the admin
		 * listing of all students in the database.
		 */
		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("delete")) {
			int postId = Integer.parseInt(request.getParameter("PostId"));
			dao.deleteRecipe(postId);
			forward = LIST_RECIPE_PUBLIC;
			request.setAttribute("RecipeDatabase", dao.getAllRecipes());
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;	
		} else if (action.equalsIgnoreCase("edit")) {
			forward = EDIT;
			int postId = Integer.parseInt(request.getParameter("PostId"));
			Recipe recipe = dao.getRecipeById(postId);
			request.setAttribute("RecipeDatabase", recipe);
		} else if (action.equalsIgnoreCase("listRecipe")) {
			request.setAttribute("RecipeDatabase", dao.getAllRecipes());
		//} else if (action.equalsIgnoreCase("listStudentAdmin")) {
			//forward = LIST_STUDENT_ADMIN;
			//request.setAttribute("RecipeDatabase", dao.getAllStudents());
		} else {
			forward = INSERT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 
		/**
		 * This method retrieves all of the information entered in the form on
		 * the addRecipe.jsp or the editRecipe.jsp pages.
		 */
		Recipe newRecipe = new Recipe();
		newRecipe.setRecipeTitle(request.getParameter("recipetitle"));
		newRecipe.setImageUrl(request.getParameter("imageurl"));
		newRecipe.setServing(request.getParameter("serving"));
		newRecipe.setDifficulty(request.getParameter("difficulty"));
		newRecipe.setPrepTime(request.getParameter("preptime"));
		newRecipe.setIngredients(request.getParameter("ingredients"));
		newRecipe.setInstructions(request.getParameter("instructions"));
		newRecipe.setDishType(request.getParameter("dishtype"));
		newRecipe.setCuisineType(request.getParameter("cuisinetype"));	
		newRecipe.setUsername((String) session.getAttribute("username"));
		
		String postid = request.getParameter("postid");
		/**
		 * If the 'postid' field in the form is empty, the new recipe will
		 * be added to the list of Recipe objects.
		 */
		if (postid == null || postid.isEmpty()) {
			dao.addRecipe(newRecipe);
		} else {
			/**
			 * Otherwise, if the field is already filled (this occurs when the
			 * user is trying to Edit A Student), then the student's information
			 * will be updated accordingly.
			 */
			newRecipe.setPostID(Integer.parseInt(postid));
			dao.updateRecipe(newRecipe);
		}
		
		/**
		 * Once the recipe has been added or updated, the page will redirect to
		 * the listing of students.
		*/ 
		RequestDispatcher view = request.getRequestDispatcher(LIST_RECIPE_PUBLIC);
		request.setAttribute("recipes", dao.getAllRecipes());
		view.forward(request, response);
		}
}
