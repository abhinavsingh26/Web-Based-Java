package com.Day_6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fdbg
 */
@WebServlet("/fdbg")
public class fdbg extends HttpServlet {
	private static final long serialVersionUID = 1L;
      @Override
	public String toString() {
		return "fdbg [getInitParameterNames()=" + getInitParameterNames() + ", getServletConfig()=" + getServletConfig()
				+ ", getServletContext()=" + getServletContext() + ", getServletInfo()=" + getServletInfo()
				+ ", getServletName()=" + getServletName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	// jl.ll/..kl;
    /**
     * @see HttpServlet#Htt./km./pServlet()
     <b>    */
    public fdbg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}