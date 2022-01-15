package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		
		String name = request.getParameter("name");
		String address = request.getParameter("addresss");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		
		
		Employee emp = new Employee(name, address,email, contact);
		EmployeeDao edao = new EmployeeDao();
		
		try {
			edao.insertEmployee(emp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
