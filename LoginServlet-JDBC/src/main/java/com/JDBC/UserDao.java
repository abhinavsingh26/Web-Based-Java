package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public boolean validateUser(String uname, String password) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_details","root","eov3zl5ilx7c");
		
		System.out.println("Connection got with mysql");
		
		String q= "select * from uid where uname = ? and password= ? ";
		PreparedStatement pmt = con.prepareStatement(q);
		
		pmt.setString(1, uname);
		pmt.setString(2, password);
		
		ResultSet rs=pmt.executeQuery();
		
		if (rs.next()) {
			return true;
		}else {
			return false;
		}
	}
}
