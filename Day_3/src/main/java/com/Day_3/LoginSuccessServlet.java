package com.Day_3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet({ "/LoginSuccessServlet", "/success" })
public class LoginSuccessServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		ServletContext context = getServletContext();
		String dname = context.getInitParameter("drivername");
		out.println("Context param value is = " + dname);
		
		String name = (String) request.getAttribute("name");
		out.println("Login Success...<br>");
		out.println("Welcome : " + name);
	}

}
