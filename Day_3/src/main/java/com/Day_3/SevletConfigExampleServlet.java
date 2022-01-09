package com.Day_3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/readparam")
public class SevletConfigExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * ServletConfig config = getServletConfig(); String dbname =
		 * config.getInitParameter("dbname");
		 */
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		//out.println("param value is = " + dbname); 
		
		ServletContext context = getServletContext();
		String dname = context.getInitParameter("drivername");
		out.println("Context param value is = " + dname);
	}

}
