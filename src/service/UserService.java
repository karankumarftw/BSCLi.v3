package service;

import dao.UserDAO;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
  UserDAO userDAO = new UserDAO();

  public String userDelete(int userID) throws SQLException {
    return userDAO.delete(String.valueOf(userID));
  }

  public String createUser(User user) throws SQLException {
    return userDAO.createUser(user);
  }

  public ResultSet userList() throws SQLException {
    return userDAO.list();
  }
}
