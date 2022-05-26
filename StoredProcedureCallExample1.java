import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcedureCallExample1 {

	public static void main(String[] args) {

		Statement stmt = null;
		String url = "jdbc:mariadb://localhost:3306/tutorial";
		final String user = "root";
		final String pwd = "root";

		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			CallableStatement statement = conn.prepareCall("{call create_author(?,?)}");
			statement.setString(1,"Bill Gates");
			statement.setString(2, "bill@microsoft.com");

			statement.execute();
			statement.close();

			System.out.println("Stored procedure called successfully!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
