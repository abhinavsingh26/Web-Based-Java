package management.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","eov3zl5ilx7c");
			
		System.out.println("connection got with mysql");

	}

}
