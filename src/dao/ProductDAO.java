package dao;

import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
  /**
   * Creates a new entry for the specified Product object.
   *
   * @param proObj the Product object for which to create an entry
   * @throws SQLException if an error occurs during the creation process
   */
  void create(Product proObj) throws SQLException;
  /**
   * Edits the specified Product object.
   *
   * @param proObj the Product object to be edited
   * @return a String representing the result of the operation
   * @throws SQLException if an error occurs during the editing process
   */
  void edit(Product proObj) throws SQLException;
  /**
   * Deletes the specified data.
   * @return Returns affected row count
   * @param data the data to be deleted
   * @throws SQLException if an error occurs during the deletion process
   */
  Integer delete(String data) throws SQLException;

  /**
   * Retrieves the count of items.
   *
   * @return the count of items
   * @throws SQLException if an error occurs while retrieving the count
   */
  int count() throws SQLException;

  /**
   * Retrieves a list of Product objects.
   *
   * @return an ArrayList containing the list of Product objects
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<Product> list() throws SQLException;

  /**
   * Retrieves a list of Product objects with a specified page limit.
   *
   * @param limitCount the maximum number of items to retrieve per page
   * @return an ArrayList containing the list of Product objects
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<Product> listWithPageLimit(int limitCount) throws SQLException;

  /**
   * Retrieves a list of Product objects with a specified page limit and page count.
   *
   * @param pageLimit the maximum number of items to retrieve per page
   * @param pageCount the number of pages to retrieve
   * @return an ArrayList containing the list of Product objects
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<Product> listWithPageLimitAndPageCount(int pageLimit, int pageCount)
      throws SQLException;

  /**
   * Performs a global search for Product objects based on the specified search value.
   *
   * @param searchValue the value to search for
   * @return an ArrayList containing the list of matching Product objects
   * @throws SQLException if an error occurs during the search process
   */
  ArrayList<Product> globalSearch(String searchValue) throws SQLException;

  /**
   * Performs a search for Product objects based on the specified attribute and search value.
   *
   * @param attr the attribute to search within
   * @param searchValue the value to search for
   * @return an ArrayList containing the list of matching Product objects
   * @throws SQLException if an error occurs during the search process
   */
  ArrayList<Product> searchWithAttribute(String attr, String searchValue) throws SQLException;

  /**
   * Performs a search for Product objects based on the specified attribute and search value, with
   * pagination support.
   *
   * @param attr the attribute to search within
   * @param searchValue the value to search for
   * @param pageLimit the maximum number of items to retrieve per page
   * @param pageCount the number of pages to retrieve
   * @return an ArrayList containing the list of matching Product objects
   * @throws SQLException if an error occurs during the search process
   */
  ArrayList<Product> searchWithAttributeAndPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException;

  /**
   * Retrieves the price of the item with the specified code.
   *
   * @param code the code of the item to retrieve the price for
   * @return the price of the item
   * @throws SQLException if an error occurs while retrieving the item price
   */
  double getItemPrice(int code) throws SQLException;
}
