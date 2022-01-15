package com.Day_6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.Day_6.UserDao;


public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");    
		
		//UserDao ud = new UserDao();
		
		String name = request.getParameter("name"); 
		String password = request.getParameter("password");
		
		if(name.equals("admin") && password.equals("admin")) {
			
			
			out.println("Login Success");
			
			response.sendRedirect("LoginSuccess?uname"+name);
			
			//response.sendRedirect("http://www.google.com");
										
			//RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess");
			//rd.forward(request, response);
		}else {
			out.print("Incorrect login details , Login Again");
		}
	}

}
 