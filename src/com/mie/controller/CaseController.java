package com.mie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.CaseDao;

public class CaseController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String LIST_CASE = "/listcase.jsp";

	private CaseDao dao;

	public CaseController() {
		super();
		dao = new CaseDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listcase")) {
			forward = LIST_CASE;
			request.setAttribute("cases", dao.getAllCases());
		} else {
			forward = LIST_CASE;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}