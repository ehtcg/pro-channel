import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement stmt = null;
		String url = "jdbc:mariadb://localhost:3306/tutorial";
		final String  user  = "root";
	     final  String   pwd = "root";

		conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("Successfully connected to database");

		try {
			// STEP 2: Register JDBC driver
			Class.forName("org.mariadb.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			/*
			 * conn = DriverManager.getConnection( "jdbc:mariadb://192.168.100.174/db",
			 * "root", "root"); System.out.println("Connected database successfully...");
			 * 
			 * //STEP 4: Execute a query
			 * System.out.println("Creating table in given database...");
			 * 
			 */
			stmt = conn.createStatement();

			String sql = "CREATE TABLE REGISTRATION " + "(id INTEGER not NULL, " + " first VARCHAR(255), "
					+ " last VARCHAR(255), " + " age INTEGER, " + " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null) {
					conn.close();
				}
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end JDBCExample
