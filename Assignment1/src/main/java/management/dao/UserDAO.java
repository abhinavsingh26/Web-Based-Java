package management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import management.model.User;


public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/shop";
	private String jdbcUsername = "root";
	private String jdbcPassword = "eov3zl5ilx7c";
	

		
		
		private static final String INSERT_USERS_SQL = "INSERT INTO product" + "  (pname, pprice, pquantity, pdiscount) VALUES "
				+ " (?, ?, ?, ?);";
		private static final String SELECT_USER_BY_ID = "select pname, pprice, pquantity, pdiscount from product where pid =?";
	    private static final String SELECT_ALL_USERS = "select * from product";
	    private static final String DELETE_USERS_SQL = "delete from product where pid = ?;";
	    private static final String UPDATE_USERS_SQL = "update product set pname = ?, pprice = ?, pquantity =?, pdiscount = ? where pid = ?;";

	    public UserDAO() {
		}
//---------------------------------------------------------------------------------------------------------------------
	    
		protected Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
		}
//-------------------------------------------------------------------------------------------------------------------------------------
		
		public void insertUser(User user) throws SQLException {
			System.out.println(INSERT_USERS_SQL);
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				preparedStatement.setString(1, user.getPname());
				preparedStatement.setString(2, user.getPprice());
				preparedStatement.setString(3, user.getPquantity());
				preparedStatement.setString(4, user.getPdiscount());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
//--------------------------------------------------------------------------------------------------------------------------------
		public User selectUser(int pid) {
			User user = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
				preparedStatement.setInt(1, pid);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String pname = rs.getString("pname");
					String pprice = rs.getString("pprice");
					String pquantity = rs.getString("pquantity");
					String pdiscount = rs.getString("pdiscount");
					user = new User(pid, pname, pprice, pquantity,pdiscount);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return user;
		}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
		public List<User> selectAllUsers() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			List<User> users = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int pid = rs.getInt("pid");
					String pname = rs.getString("pname"); 
					String pprice = rs.getString("pprice");
					String pquantity = rs.getString("pquantity");
					String pdiscount = rs.getString("pdiscount");
					users.add(new User(pid, pname, pprice, pquantity,pdiscount));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return users;
		}
//------------------------------------------------------------------------------------------------------
		
		public boolean deleteUser(int pid) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
				statement.setInt(1, pid);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
//---------------------------------------------------------------------------------------------------------------------------------------------------------
		public boolean updateUser(User user) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
				statement.setString(1, user.getPname());
				statement.setString(2, user.getPprice());
				statement.setString(3, user.getPquantity());
				statement.setString(4, user.getPdiscount());
				statement.setInt(5, user.getPid());
				
				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}
//-----------------------------------------------------------------------------------------------------------------------------------
		private void printSQLException(SQLException ex) {
			for (Throwable e : ex) {
				if (e instanceof SQLException) {
					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}

}
