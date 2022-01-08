package com.Day_3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet({ "/LoginSuccessServlet", "/success" })
public class LoginSuccessServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		String name = (String) request.getAttribute("name");
		
		out.println("Login Success...");
		out.println("Welcome : " + name);
	}

}
