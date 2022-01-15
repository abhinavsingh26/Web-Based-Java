package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

         String action = request.getServletPath();
      
          if(action.equals("/Emp"))
          {
          		insertEmp(request,response);
          	
          }else if(action.equals("/Success")){
        	  try {
				ViewEmp(request,response);
        	  } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
           
	}
	
      	private void ViewEmp(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException
      	{
		
      		EmployeeDao edao = new EmployeeDao();
      		
      		ArrayList<Employee> list =edao.ViewAllEmployee();
      		
      		request.setAttribute("elist", list);
      		
      		RequestDispatcher rd= request.getRequestDispatcher("viewEmp");
  			rd.include(request, response);
      		
		
      	}

		private void insertEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
			
			
			String name=request.getParameter("name");  
          String address=request.getParameter("address");  
          String email=request.getParameter("email");
          String contact=request.getParameter("contact");
  		
  		Employee emp = new Employee(name,address,email,contact);
  		EmployeeDao edao = new EmployeeDao();
  		
          try {
  			
          	int result=edao.insertEmployee(emp);
          	if(result !=0)
          	{
          		
          		 out.println("Employee record inserted successfully");
          		RequestDispatcher rd= request.getRequestDispatcher("Register.html");
      			rd.include(request, response);
          		
          	}else
          	{
          		out.println("not inserted");
          	}
          		
  			
  		} catch (ClassNotFoundException | SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}

      	}
          
	}

