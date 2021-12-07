package com.mie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.model.Moderator;
import com.mie.model.Student;
import com.mie.model.User;
import com.mie.dao.UserDao;

/**
 * Servlet implementation for LoginController.
 * 
 * This class handles the login servlet and assigns session attributes for users
 * who succesfully log into the system.
 */
public class LoginController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered username and password from the login.jsp form.
		 */
		User user = new User();
		user.setUsername(request.getParameter("uname"));
		user.setPassword(request.getParameter("pass"));

		try {
			//if user is a moderator -> login as a moderator
			if (UserDao.checkUserType(user)){
				
				/**
				 * Try to see if the moderator can log in.
				 */
				Moderator moderator = (Moderator) UserDao.moderatorLogin(user);
				
				/**
				 * If the isValid value is true, assign session attributes to the
				 * current member.
				 */
				if (moderator.isValid()){
					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", moderator);
					session.setAttribute("username", moderator.getUsername());
					
					/**
					 * Redirect to the members-only home page.
					 */
					response.sendRedirect("moderatorLogged.jsp");

					/**
					 * Set a timeout variable of 900 seconds (15 minutes) for this
					 * member who has logged into the system.
					 */
					session.setMaxInactiveInterval(900);
				}
				else {
						/**
						 * Otherwise, redirect the user to the invalid login page and
						 * ask them to log in again with the proper credentials.
						 */
						response.sendRedirect("invalidLogin.jsp");
					}
			}
			
			else{
				 
				/* Try to see if the student can log in. */
				
				Student student = (Student) UserDao.studentLogin(user);

				/**
				 * If the isValid value is true, assign session attributes to the
				 * current member.
				 */
				if (student.isValid()) {

					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", student);
					session.setAttribute("username", student.getUsername());
					session.setAttribute("name", student.getName());
					/**
					 * Redirect to the members-only home page.
					 */
					response.sendRedirect("memberLogged.jsp");

					/**
					 * Set a timeout variable of 900 seconds (15 minutes) for this
					 * member who has logged into the system.
					 */
					session.setMaxInactiveInterval(900);
				}

				else {
					/**
					 * Otherwise, redirect the user to the invalid login page and
					 * ask them to log in again with the proper credentials.
					 */
					response.sendRedirect("invalidLogin.jsp");
				}
			}

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
