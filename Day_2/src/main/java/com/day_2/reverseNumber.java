package com.day_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class reverseNumber extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
			
		
		PrintWriter out =  res.getWriter();
		res.setContentType("text/html"); 
		out.println(" Reverse Number is :  ");

		int num2 =Integer.parseInt(req.getParameter("n1"));
		

		
		int rev_num = 0;
	    while (num2 > 0)
	    {
	        rev_num = rev_num*10 + num2%10;
	        num2 = num2/10;
	    }
	    out.println(rev_num);
		
	}
}