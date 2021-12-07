package com.mie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.PowerDao;

public class PowerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String LIST_POWER = "/listpower.jsp";

	private PowerDao dao;

	public PowerController() {
		super();
		dao = new PowerDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listpower")) {
			forward = LIST_POWER;
			request.setAttribute("powers", dao.getAllPowers());
		} else {
			forward = LIST_POWER;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}