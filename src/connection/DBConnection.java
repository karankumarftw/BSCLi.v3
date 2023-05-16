package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
  public static final java.sql.Connection connection;
  public static final Statement statement;

  static {
    try {
      connection =
          DriverManager.getConnection(
              "jdbc:postgresql://localhost:5432/vels", "postgres", "postgres");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  static {
    try {
      statement = connection.createStatement();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
