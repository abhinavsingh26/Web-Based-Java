package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public boolean validateUser(User user) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_details","root","eov3zl5ilx7c");
		
		System.out.println("Connection got with mysql");
		
		String q= "select * from uid where uname = ? and password= ? ";
		PreparedStatement pmt = con.prepareStatement(q);
		
		pmt.setString(1, user.getUsername());
		pmt.setString(2, user.getPassword());
		
		ResultSet rs=pmt.executeQuery();
		
		boolean status;
		
		if (rs.next()) {
			status =  true;
		}
		else {
			status =  false;
		}
		
		return status;
	}
}
;