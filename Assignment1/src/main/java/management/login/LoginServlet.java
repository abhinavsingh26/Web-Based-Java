package management.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.Day_6.UserDao;


public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");    
		
		//UserDao ud = new UserDao();
		
		String name = request.getParameter("name"); 
		String password = request.getParameter("password");
		
		if(name.equals("admin") && password.equals("admin")) {
			
			response.sendRedirect("user-list.jsp");
			
		}else {
			out.print("Incorrect login details , Login Again");
		}
	}

}
 

