package dao;

import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
  /**
   * Deletes a user record based on the provided username.
   *
   * @param userName the username of the user to delete
   * @return an Integer representing the result of the deletion operation
   * @throws SQLException if an error occurs during the deletion process
   */
  Integer delete(String userName) throws SQLException;

  /**
   * Retrieves the count of user records.
   *
   * @return the count of user records
   * @throws SQLException if an error occurs while retrieving the count
   */
  int count() throws SQLException;

  /**
   * Creates a new user record based on the provided User object.
   *
   * @param user the User object representing the user to create
   * @throws SQLException if an error occurs during the creation process
   */
  void create(User user) throws SQLException;

  /**
   * Updates an existing user record based on the provided User object.
   *
   * @param user the User object representing the updated user information
   * @throws SQLException if an error occurs during the update process
   */
  void edit(User user) throws SQLException;

  /**
   * Retrieves a list of users.
   *
   * @return an ArrayList containing the list of User objects representing the users
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<User> list() throws SQLException;

  /**
   * Retrieves a limited number of users based on the provided page limit.
   *
   * @param limitCount the maximum number of users to retrieve
   * @return an ArrayList containing the list of User objects representing the users
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<User> listWithPageLimit(int limitCount) throws SQLException;

  /**
   * Retrieves a limited number of users based on the provided page limit and page count.
   *
   * @param pageLimit the maximum number of users to retrieve per page
   * @param pageCount the page count representing the specific page to retrieve
   * @return an ArrayList containing the list of User objects representing the users
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<User> listWithPageLimitAndPageCount(int pageLimit, int pageCount) throws SQLException;

  /**
   * Performs a global search for users based on the provided search value.
   *
   * @param searchValue the value to search for within user records
   * @return an ArrayList containing the list of User objects matching the search criteria
   * @throws SQLException if an error occurs during the search process
   */
  ArrayList<User> globalSearch(String searchValue) throws SQLException;

  /**
   * Performs a search for users based on the provided attribute and search value.
   *
   * @param attr the attribute to search within user records
   * @param searchValue the value to search for within the specified attribute
   * @return an ArrayList containing the list of User objects matching the search criteria
   * @throws SQLException if an error occurs during the search process
   */
  ArrayList<User> searchWithAttribute(String attr, String searchValue) throws SQLException;

  /**
   * Performs a search for users based on the provided attribute and search value, with pagination
   * support.
   *
   * @param attr the attribute to search within user records
   * @param searchValue the value to search for within the specified attribute
   * @param pageLimit the maximum number of users to retrieve per page
   * @param pageCount the page count representing the specific page to retrieve
   * @return an ArrayList containing the list of User objects matching the search criteria
   * @throws SQLException if an error occurs during the search process
   */
  ArrayList<User> searchWithAttributeWithPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException;
}
