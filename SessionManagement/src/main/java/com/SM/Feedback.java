package com.SM;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Feedback extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
				
		request.getRequestDispatcher("Menu.html").include(request, response);
				
		Cookie ck[] =request.getCookies();
		
		if(ck != null)
		{
			String name = ck[0].getValue();
		
			if(!name.equals("") || name != null) {
			
				out.print("<br>Welcome : " + name);
				out.print("<b>You are allowed to give feedback</b>");
		}
		}else {
			
			out.print("Please login Again..");
			request.getRequestDispatcher("Login.html").include(request, response);
			
		}
		out.close();
	}

}
