package dao;

import connection.DBConnection;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements Delete {

  public String delete(String userName) throws SQLException {
    String query = "DELETE FROM USERS WHERE USER_NAME = " + userName;
    DBConnection.statement.execute(query);
    return "User deleted successfully";
  }

  public int userCount() throws SQLException {
    String query = "select count(*) from users";
    ResultSet rs = DBConnection.statement.executeQuery(query);
    return rs.getInt("count");
  }

  public String createUser(User user) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(
            "INSERT INTO USERS (USER_TYPE,USER_NAME,USER_PASSWORD,USER_FIRSTNAME,USER_LASTNAME,USER_PHONENUMBER) VALUES (?,?,?,?,?,?)");
    ps.setString(1, user.getUserType());
    ps.setString(2, user.getUserName());
    ps.setString(3, user.getPassword());
    ps.setString(4, user.getFirstName());
    ps.setString(5, user.getLastName());
    ps.setLong(6, user.getUserPhoneNumber());
    ps.executeUpdate();
    return "New user created successfully";
  }

  public String editUser(User user) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(
            "UPDATE USERS SET USER_TYPE = ? ,PASSWORD = ? ,FIRST_NAME = ? ,LAST_NAME = ? ,PHONE_NUMBER = ? WHERE USER_NAME = ? ");
    ps.setString(1, user.getUserType());
    ps.setString(2, user.getPassword());
    ps.setString(3, user.getFirstName());
    ps.setString(4, user.getLastName());
    ps.setLong(5, user.getUserPhoneNumber());
    ps.setString(6, user.getUserName());
    ps.executeUpdate();
    return "user Edit successfully";
  }

  private ArrayList<User> results(String query) throws SQLException {
    ArrayList<User> listOfUsers = new ArrayList<>();
    ResultSet rs = DBConnection.statement.executeQuery(query);
    while (rs.next()) {
      int id = rs.getInt("id");
      String userType = rs.getString("user_type");
      String userName = rs.getString("user_name");
      String firstName = rs.getString("user_firstname");
      String password = rs.getString("user_password");
      String lastName = rs.getString("user_lastname");
      long phoneNumber = rs.getLong("user_phonenumber");
      User user = new User(id, userType, userName, password, firstName, lastName, phoneNumber);
      listOfUsers.add(user);
    }
    return listOfUsers;
  }

  public ArrayList<User> list() throws SQLException {
    String query = "SELECT * FROM USERS ORDER BY ID LIMIT 20";
    return results(query);
  }

  public ArrayList<User> listWithPageLimit(int limitCount) throws SQLException {
    String query = "SELECT * FROM USERS LIMIT " + limitCount;
    return results(query);
  }

  public ArrayList<User> listWithPageLimitAndPageCount(int pageLimit, int pageCount)
      throws SQLException {
    int offset;
    if (pageCount == 1) {
      offset = 0;
    } else {
      offset = (pageCount - 1) * pageLimit;
    }
    String query = "SELECT * FROM USERS OFFSET " + offset + "  LIMIT " + pageLimit;
    return results(query);
  }

  public ArrayList<User> globalSearch(String searchValue) throws SQLException {
    String query =
        "SELECT * FROM PRODUCTS WHERE UNIT_CODE ILIKE '%"
            + searchValue
            + "%' OR UNIT_NAME ILIKE '%"
            + searchValue
            + "%' ";
    return results(query);
  }

  public ArrayList<User> searchWithAttribute(String attr, String searchValue) throws SQLException {
    String query = "select * from users where '" + attr + "' = '" + searchValue + "'";
    return results(query);
  }

  public ArrayList<User> searchWithAttributeWithPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException {
    int offset;
    if (pageCount == 1) {
      offset = 0;
    } else {
      offset = (pageCount - 1) * pageLimit;
    }
    String query =
        "select * from products users '"
            + attr
            + "' = '"
            + searchValue
            + "' OFFSET "
            + offset
            + "  LIMIT "
            + pageLimit;
    return results(query);
  }
}
