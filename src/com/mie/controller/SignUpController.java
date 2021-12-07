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
 * This class handles the SignUp servlet and assigns session attributes for
 * users who succesfully log into the system.
 */
public class SignUpController extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered profile information from the signup.jsp form.
		 */
		UserDao dao = new UserDao();
		String username = request.getParameter("uname");
		try {
			Student student = new Student();
			HttpSession session = request.getSession(true);

			
			
			//Add check for if it exists already
			
			
			//Check if the login is a moderator and redirect them to the user login
			if (UserDao.checkIfExists(username) || UserDao.checkIfModerator(username)){
				response.sendRedirect("invalidSignUp.jsp");
			}else{
				student.setName(request.getParameter("fname"));
				student.setUsername(username);
				student.setEmail(request.getParameter("email"));
				student.setPassword(request.getParameter("pass"));
				student.setBio(request.getParameter("bio"));
				student.setLocation(request.getParameter("location"));
				student.setPhotoUrl(request.getParameter("dp"));
				
				
				
				
				session.setAttribute("currentSessionUser", student);
				session.setAttribute("username", student.getUsername());
				
				if (dao.addStudent(student)) {
					response.sendRedirect("studentProfile.jsp");
					/**
					 * Set a timeout variable of 900 seconds (15 minutes) for this
					 * member who has logged into the system.
					 */
					session.setMaxInactiveInterval(900);
				} else {
					response.sendRedirect("invalidSignUp.jsp");
				}
			}
			
			



		} catch (Throwable theException) {
			/**
			 * Print out any errors.
			 */
			System.out.println(theException);
		}
	}
}
