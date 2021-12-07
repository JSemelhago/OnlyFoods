package com.mie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.CPUDao;

public class CPUController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String LIST_CPU = "/listcpu.jsp";

	private CPUDao dao;

	public CPUController() {
		super();
		dao = new CPUDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listcpu")) {
			forward = LIST_CPU;
			request.setAttribute("cpus", dao.getAllCPUs());
		} else {
			forward = LIST_CPU;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}