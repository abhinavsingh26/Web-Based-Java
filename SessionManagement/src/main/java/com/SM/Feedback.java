package com.SM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
				
		Cookie ck[] =request.getCookies();
		String name = ck[0].getValue();
		
		if(!name.equals(" "))
		{
			out.println("Welcome : " + name);
			out.println("You are allowed to give feedback");
		
		}else {
			
			out.println("Login Again..");
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("Menu.html");
		rd.forward(request,response);
		
		
		
		
	}

}
