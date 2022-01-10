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
		
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		
		request.getRequestDispatcher("Menu.html").include(request, response);
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if(password.equals("admin")) {
			
			out.print("You are successfully logged in. ");
			out.print("<br>Welcome , " + name);
			
			Cookie ck = new Cookie("user", name);
			response.addCookie(ck);
			
		}else {
			
			out.print("sorry,username or password error ! ");
			request.getRequestDispatcher("Login.html").include(request, response);
			
		}		 
		out.close();

	}
}
