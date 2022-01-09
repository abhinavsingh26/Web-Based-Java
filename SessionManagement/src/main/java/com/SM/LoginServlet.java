package com.SM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		 
		Cookie ck = new Cookie("user", name);
		response.addCookie(ck);
		
		out.println("Login Success.");
		
		RequestDispatcher rd = request.getRequestDispatcher("Menu.html");
		rd.include(request,response);

	}

}
