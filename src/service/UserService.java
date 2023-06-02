package service;

import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserService {
    String delete(String userName) throws SQLException;

    String create(User user) throws SQLException;

    String edit(User user) throws SQLException;

    ArrayList<User> list() throws SQLException;

    ArrayList<User> globalSearch(String searchValue) throws SQLException;

    ArrayList<User> searchWithAttribute(String attr, String searchValue) throws SQLException;

    ArrayList<User> searchWithAttributeWithPaging(
            String attr, String searchValue, int pageLimit, int pageCount) throws SQLException;

    ArrayList<User> listWithPageLimitAndPageCount(String pageLimit, String pageCount)
            throws NotANumberException;

    ArrayList<User> listWithPageLimit(String pageLimit) throws NotANumberException;

    int count() throws SQLException;
}
