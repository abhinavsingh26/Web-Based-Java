package com.day_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AddServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
			
		System.out.println("welcome to Add servlet ");
		PrintWriter out =  res.getWriter();
		res.setContentType("text/html"); 
			
		int num1 =Integer.parseInt(req.getParameter("n1"));
		int num2 =Integer.parseInt(req.getParameter("n2"));
		int sum = num1+num2;

		out.println("sum of num1 + num2 = " + sum);
	}
}
