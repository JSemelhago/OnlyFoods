package com.mie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.MotherboardDao;

public class MotherboardController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String LIST_MOTHERBOARD = "/listmotherboard.jsp";

	private MotherboardDao dao;

	public MotherboardController() {
		super();
		dao = new MotherboardDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listmotherboard")) {
			forward = LIST_MOTHERBOARD;
			request.setAttribute("motherboards", dao.getAllMotherboards());
		} else {
			forward = LIST_MOTHERBOARD;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}