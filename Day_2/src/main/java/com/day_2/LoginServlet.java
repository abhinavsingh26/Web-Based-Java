package com.day_2;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
			
		
		PrintWriter out =  res.getWriter();
		res.setContentType("text/html"); 
		System.out.println("welcome to Login servlet ");
		out.println("welcome to Login servlet ");
		
	}
	
	
}
