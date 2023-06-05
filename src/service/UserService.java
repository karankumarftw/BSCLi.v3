package service;

import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserService {
  /**
   * Deletes the user with the specified username from the system.
   *
   * @param userName The username of the user to be deleted.
   * @return An Integer indicating the result of the delete operation.
   * @throws SQLException if there is an error executing the database operation.
   */
  Integer delete(String userName) throws SQLException;

  /**
   * Creates a new user in the system.
   *
   * @param user The User object representing the user to be created.
   * @return A string indicating the result of the create operation.
   * @throws SQLException if there is an error executing the database operation.
   */
  void create(User user) throws SQLException;

  /**
   * Edits an existing user in the system.
   *
   * @param user The User object representing the updated user information.
   * @return A string indicating the result of the edit operation.
   * @throws SQLException if there is an error executing the database operation.
   */
  void edit(User user) throws SQLException;

  /**
   * Retrieves a list of users from the system.
   *
   * @return An ArrayList of User objects containing the retrieved users.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<User> list() throws SQLException;

  /**
   * Performs a global search for users based on the provided search value.
   *
   * @param searchValue The value to search for among user attributes.
   * @return An ArrayList of User objects containing the search results.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<User> globalSearch(String searchValue) throws SQLException;

  /**
   * Performs a search for users based on the specified attribute and search value.
   *
   * @param attr The attribute to search for (e.g., "username", "email").
   * @param searchValue The value to search for within the specified attribute.
   * @return An ArrayList of User objects containing the search results.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<User> searchWithAttribute(String attr, String searchValue) throws SQLException;

  /**
   * Performs a search for users based on the specified attribute and search value, with support for
   * paging.
   *
   * @param attr The attribute to search for (e.g., "username", "email").
   * @param searchValue The value to search for within the specified attribute.
   * @param pageLimit The maximum number of results per page.
   * @param pageCount The page number to retrieve.
   * @return An ArrayList of User objects containing the search results for the specified page.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<User> searchWithAttributeWithPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException;

  /**
   * Retrieves a list of users from the system with support for page limit and page count.
   *
   * @param pageLimit The maximum number of users to retrieve per page.
   * @param pageCount The page number to retrieve.
   * @return An ArrayList of User objects containing the retrieved users for the specified page.
   * @throws NotANumberException if the page limit or page count is not a valid number.
   */
  ArrayList<User> listWithPageLimitAndPageCount(String pageLimit, String pageCount)
      throws NotANumberException;

  /**
   * Retrieves a list of users from the system with the specified page limit.
   *
   * @param pageLimit The maximum number of users to retrieve per page.
   * @return An ArrayList of User objects containing the retrieved users.
   * @throws NotANumberException if the page limit is not a valid number.
   */
  ArrayList<User> listWithPageLimit(String pageLimit) throws NotANumberException;

  /**
   * Retrieves the total number of users in the system.
   *
   * @return The total number of users.
   * @throws SQLException if there is an error executing the database operation.
   */
  int count() throws SQLException;
}
