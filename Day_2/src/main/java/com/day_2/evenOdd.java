package com.day_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class evenOdd extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
			
		
		PrintWriter out =  res.getWriter();
		res.setContentType("text/html"); 
		

		int num3 =Integer.parseInt(req.getParameter("n3"));
		if((num3 % 2) == 0) {
			out.println(" Number is Even . ");
		}else {
			out.println(" Number is Odd . ");
		}
		
	}
}