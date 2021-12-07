package com.mie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.GraphicsDao;

public class GraphicsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String LIST_GRAPHICS = "/listgraphics.jsp";

	private GraphicsDao dao;

	public GraphicsController() {
		super();
		dao = new GraphicsDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listgraphics")) {
			forward = LIST_GRAPHICS;
			request.setAttribute("graphicsCards", dao.getAllGraphics());
		} else {
			forward = LIST_GRAPHICS;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}