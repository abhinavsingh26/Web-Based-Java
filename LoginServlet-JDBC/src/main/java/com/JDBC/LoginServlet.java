package com.JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		
		UserDao ud = new UserDao();
		User user;
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		user = new User(name, password);

		try {
			if(ud.validateUser(user)) {
				
				out.print("You are successfully logged in. ");
				out.print("<br>Welcome , " + name);
				
			}else {
				
				out.print("sorry,Username or Password error ! ");
				request.getRequestDispatcher("Login.html").include(request, response);
				
			}
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		out.close();
	}
}
