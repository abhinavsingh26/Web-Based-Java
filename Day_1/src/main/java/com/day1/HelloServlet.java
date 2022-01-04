package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello") //annotation

public class HelloServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException, IOException 
	{
			
		System.out.println("welcome to java servlet ");
		PrintWriter out =  res.getWriter();
		res.setContentType("text/html"); 
		
		String name=(String) req.getParameter("name");
		out.println("<h1>"+"Welcome "+ name +"</h1");
	}
}
