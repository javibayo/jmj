package com.jmj.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class indexServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		
		try {
			resp.getWriter().println("hola!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
