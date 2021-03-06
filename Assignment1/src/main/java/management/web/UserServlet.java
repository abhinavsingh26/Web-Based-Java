package management.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import management.model.User;
import management.dao.UserDAO;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAO();
	}
//----------------------------------------------------------------------------------------------------------
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
//-------------------------------------------------------------------------------------------------------
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	//------------------------------------------------------------------------------------------------------------------------
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	//------------------------------------------------------------------------------------------------------------------------
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		User existingUser = userDAO.selectUser(pid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	//--------------------------------------------------------------------------------------
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String pname = request.getParameter("pname");
		String pprice = request.getParameter("pprice");
		String pquantity = request.getParameter("pquantity");
		String pdiscount = request.getParameter("pdiscount");
		User newProduct = new User( pname, pprice, pquantity,pdiscount);
		userDAO.insertUser(newProduct);
		response.sendRedirect("list");
	}
//------------------------------------------------------------------------------------------------------------------------------------
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		String pprice = request.getParameter("pprice");
		String pquantity = request.getParameter("pquantity");
		String pdiscount = request.getParameter("pdiscount");
		User book = new User(pid, pname, pprice, pquantity,pdiscount);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	//-------------------------------------------------------------------------------------------------------------------------------
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		userDAO.deleteUser(pid);
		response.sendRedirect("list");
	}

}
