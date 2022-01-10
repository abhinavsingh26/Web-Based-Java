package com.JDBC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if(password.equals("admin") && password.equals("admin")) {
			
			out.print("You are successfully logged in. ");
			out.print("<br>Welcome , " + name);
			
			HttpSession session= request.getSession();
			session.setAttribute("name", name);
			
		}else {
			
			out.print("sorry,Username or Password error ! ");
			request.getRequestDispatcher("Login.html").include(request, response);
			
		}		 
		out.close();

	}

}