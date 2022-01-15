package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
	public static Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_details","root","eov3zl5ilx7c");

		return con;
		
	}
	
	
	public int insertEmployee(Employee emp) throws ClassNotFoundException, SQLException 
	{     
		Connection con = EmployeeDao.createConnection();
		
		String q = "insert into employee values(?,?,?,?)";
		
		PreparedStatement pmt = con.prepareStatement(q);
		
		pmt.setString(1, emp.getName());
		pmt.setString(2, emp.getAddress());
		pmt.setString(3, emp.getEmail());
		pmt.setString(4, emp.getContact());
		
		int result=pmt.executeUpdate();
			return result;	
	}
	
	
	
	public ArrayList ViewAllEmployee() throws ClassNotFoundException, SQLException 
	{
		Connection con = EmployeeDao.createConnection();
		
		String q = "select * from employee ";
		
		PreparedStatement pmt = con.prepareStatement(q);
		
		ResultSet rs =pmt.executeQuery();
		
		ArrayList<Employee> list = new ArrayList<>();
		
		Employee emp=null;
		
			while(rs.next())
			{
			emp= new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			list.add(emp);
			
			}
		
			
			return list;
			
	}

}
