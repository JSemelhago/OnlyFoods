package com.mie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.StorageDao;

public class StorageController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String LIST_STORAGE = "/liststorage.jsp";

	private StorageDao dao;

	public StorageController() {
		super();
		dao = new StorageDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("liststorage")) {
			forward = LIST_STORAGE;
			request.setAttribute("storages", dao.getAllStorages());
		} else {
			forward = LIST_STORAGE;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}