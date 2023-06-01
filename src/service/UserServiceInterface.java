package service;

import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserServiceInterface {
  String userDelete(String userName) throws SQLException;

  String userCreate(User user) throws SQLException;

  String userEdit(User user) throws SQLException;

  ArrayList<User> userList() throws SQLException;

  ArrayList<User> globalSearch(String searchValue) throws SQLException;

  ArrayList<User> searchWithAttribute(String attr, String searchValue) throws SQLException;

  ArrayList<User> searchWithAttributeWithPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException;

  ArrayList<User> userListWithPageLimitAndPageCount(String pageLimit, String pageCount)
      throws NotANumberException;

  ArrayList<User> userListWithPageLimit(String pageLimit) throws NotANumberException;

  int userCount() throws SQLException;
}
