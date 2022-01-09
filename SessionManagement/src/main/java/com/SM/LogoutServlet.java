package com.SM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LogoutServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		out.println("Logout Successfully");

		RequestDispatcher rd = request.getRequestDispatcher("Menu.html");
		rd.include(request,response);
		
		Cookie ck = new Cookie("name", "");
		ck.setMaxAge(0);
		response.addCookie(ck); 
		
		
	}

}
