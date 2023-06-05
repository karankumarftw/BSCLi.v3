package service;

import dao.UserDAOImplementation;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImplementation implements UserService {
  UserDAOImplementation userDAO = new UserDAOImplementation();
  UserValidator userValidator = new UserValidator();

  public Integer delete(String userName) throws SQLException {
    return userDAO.delete(userName);
  }

  public void create(User user) throws SQLException {
    try {
      userValidator.validator(user);
      userDAO.create(user);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void edit(User user) throws SQLException {
    userDAO.edit(user);
  }

  public ArrayList<User> list() throws SQLException {
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

  public ArrayList<User> listWithPageLimitAndPageCount(String pageLimit, String pageCount)
      throws NotANumberException {
    try {
      return userDAO.listWithPageLimitAndPageCount(
          Integer.parseInt(pageLimit), Integer.parseInt(pageCount));
    } catch (Exception e) {
      throw new NotANumberException("Page Count and Page number should be numbers");
    }
  }

  public ArrayList<User> listWithPageLimit(String pageLimit) throws NotANumberException {
    try {
      return userDAO.listWithPageLimit(Integer.parseInt(pageLimit));
    } catch (Exception e) {
      throw new NotANumberException("Page count should be a number");
    }
  }

  public int count() throws SQLException {
    return userDAO.count();
  }
}
