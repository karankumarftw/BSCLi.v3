package dao;

import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
  String delete(String userName) throws SQLException;

  int count() throws SQLException;

  String create(User user) throws SQLException;

  String edit(User user) throws SQLException;

  ArrayList<User> list() throws SQLException;

  ArrayList<User> listWithPageLimit(int limitCount) throws SQLException;

  ArrayList<User> listWithPageLimitAndPageCount(int pageLimit, int pageCount) throws SQLException;

  ArrayList<User> globalSearch(String searchValue) throws SQLException;

  ArrayList<User> searchWithAttribute(String attr, String searchValue) throws SQLException;

  ArrayList<User> searchWithAttributeWithPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException;
}