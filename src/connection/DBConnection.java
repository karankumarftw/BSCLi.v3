package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static final java.sql.Connection connection;
	public static final Statement statement;

	static {
		try {
			String url = "jdbc:postgresql://floppy.db.elephantsql.com/wfnutumw";
			String database = "wfnutumw";
			String password = "us_9Vx_x6JpwY19OXqMPYJh1r3nTs_El";
			connection = DriverManager.getConnection(url, database, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
