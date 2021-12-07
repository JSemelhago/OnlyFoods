package com.mie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.MemoryDao;

public class MemoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String LIST_MEMORY = "/listmemory.jsp";

	private MemoryDao dao;

	public MemoryController() {
		super();
		dao = new MemoryDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listmemory")) {
			forward = LIST_MEMORY;
			request.setAttribute("memorys", dao.getAllMemorys());
		} else {
			forward = LIST_MEMORY;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}