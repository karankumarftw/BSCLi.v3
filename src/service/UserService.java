package service;

import dao.UserDAO;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService implements UserServiceInterface {
  UserDAO userDAO = new UserDAO();
  UserValidator userValidator = new UserValidator();

  public String userDelete(String userName) throws SQLException {
    return userDAO.delete(userName);
  }

  public String userCreate(User user) throws SQLException {
    try {
      userValidator.userValidator(user);
      return userDAO.createUser(user);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String userEdit(User user) throws SQLException {
    return userDAO.editUser(user);
  }

  public ArrayList<User> userList() throws SQLException {
    return userDAO.list();
  }

  public ArrayList<User> globalSearch(String searchValue) throws SQLException {
    return userDAO.globalSearch(searchValue);
  }

  public ArrayList<User> searchWithAttribute(String attr, String searchValue) throws SQLException {

    return userDAO.searchWithAttribute(attr, searchValue);
  }

  public ArrayList<User> searchWithAttributeWithPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException {
    return userDAO.searchWithAttributeWithPaging(attr, searchValue, pageLimit, pageCount);
  }

  public ArrayList<User> userListWithPageLimitAndPageCount(String pageLimit, String pageCount)
      throws NotANumberException {
    try {
      return userDAO.listWithPageLimitAndPageCount(
          Integer.parseInt(pageLimit), Integer.parseInt(pageCount));
    } catch (Exception e) {
      throw new NotANumberException("Page Count and Page number should be numbers");
    }
  }

  public ArrayList<User> userListWithPageLimit(String pageLimit) throws NotANumberException {
    try {
      return userDAO.listWithPageLimit(Integer.parseInt(pageLimit));
    } catch (Exception e) {
      throw new NotANumberException("Page count should be a number");
    }
  }

  public int userCount() throws SQLException {
    return userDAO.userCount();
  }
}
