package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SuccessServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        ArrayList<Employee> list=(ArrayList<Employee>) request.getAttribute("elist");
       
			
			for(Employee emp :list)
			{
				out.println(emp.getName() + " " + emp.getAddress() +  " " + emp.getEmail() + " " + emp.getContact());
				out.print("<br>");
				
			}
			
			
			
	}

}
