package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
	public int insertEmployee(Employee emp) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_details","root","eov3zl5ilx7c");
		
		System.out.println("Connection got with mysql");
		
		String q= "insert into employee values(?,?,?,?) ";
		PreparedStatement pmt = con.prepareStatement(q);
		
		pmt.setString(1, emp.getName());
		pmt.setString(2, emp.getAddress());
		pmt.setString(3, emp.getEmail());
		pmt.setString(4, emp.getContact());
		
		int result=pmt.executeUpdate();
		
		return result;
		
		
	}

}
