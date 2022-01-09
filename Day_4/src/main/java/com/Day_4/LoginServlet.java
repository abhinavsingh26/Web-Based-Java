package com.Day_4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		//Request Scope
		//request.setAttribute("uname", name);
		//RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess");
		//rd.forward(request,response);
		
		//Session Scope
		//HttpSession session = request.getSession();
		//session.setAttribute("user", name);
		
		//RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess");
		//rd.forward(request,response);
		
		//Application Scope
		//ServletContext sc = getServletContext();
		//sc.setAttribute("user", name);
				
		//RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess");
		//rd.forward(request,response);
		//-----------------------------------------------------------------------------------------------------------------------------
		
		Cookie ck = new Cookie("user", name);
		Cookie ck1 = new Cookie("pwd", password);
		response.addCookie(ck);
		response.addCookie(ck1);
		
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.forward(request,response);
		
	} 

}
