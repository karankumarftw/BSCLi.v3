package dao;

import connection.DBConnection;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements Delete, DefaultList {

  @Override
  public String delete(String data) throws SQLException {
    String query = "delete from users where id = " + data;
    DBConnection.statement.execute(query);
    return "User deleted successfully";
  }

  public String createUser(User user) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(
            "insert into users (user_type,user_name,password,first_name,last_name,phone_number) values (?,?,?,?,?,?)");
    ps.setString(1, user.getUserType());
    ps.setString(2, user.getUserName());
    ps.setString(3, user.getPassword());
    ps.setString(4, user.getFirstName());
    ps.setString(5, user.getLastName());
    ps.setLong(6, user.getUserPhoneNumber());
    ps.executeUpdate();
    return "New user created successfully";
  }

  @Override
  public ResultSet list() throws SQLException {
    String query = "select * from users order by id limit 20";
    return DBConnection.statement.executeQuery(query);
  }
}
