package com.Day_3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/First")
public class FirstServlet extends HttpServlet { 
	
       

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter out =  res.getWriter();
		res.setContentType("text/html");
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		out.println("welcome : "+ name);
		
	}
}    
