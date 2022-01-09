package com.Day_4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		
		//Request
		//  String name = (String) request.getAttribute("uname");
		// out.println("Welcome to login success servlet : " + name);
		 
		 //Session
		//HttpSession session = request.getSession();
		//String uname= (String) session.getAttribute("user");
		//out.println("Welcome to login success session : " + uname);
		
		// Application
		//ServletContext sc = getServletContext();
		//String uname = (String) sc.getAttribute("user");
		//out.println("Welcome to login Application session : " + uname);
		
		//Cookies
		Cookie ck[] =request.getCookies();
		//String name = ck[0].getValue();
		
		for(Cookie c: ck)
		{
			String name = c.getName();
			out.println("Welcome to login  : " + name);
		}
		
	}
      
}
