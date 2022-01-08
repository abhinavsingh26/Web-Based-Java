package com.Day_3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		if(name.equals("admin") && password.equals("admin")){
			
			request.setAttribute("name", name);
			
			RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess");
			rd.forward(request, response);
		
		
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
			
		}
		
	}

}
