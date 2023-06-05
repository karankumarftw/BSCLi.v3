package service;

import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductService {
  /**
   * Deletes the specified code from the database.
   *
   * @param code The code to be deleted.
   * @return An integer indicating the count of the deletion process.
   * @throws SQLException if there is an error executing the database operation.
   * @throws NotANumberException if the provided code is not a valid number.
   */
  Integer delete(String code) throws SQLException, NotANumberException;

  /**
   * Retrieves a list of products from the database.
   *
   * @return An ArrayList of Product objects containing the retrieved products.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<Product> list() throws SQLException;

  /**
   * Creates a new product in the database.
   *
   * @param product The Product object representing the product to be created.
   * @throws SQLException if there is an error executing the database operation.
   * @throws NotANumberException if the product ID or any numeric field in the product is not a
   *     valid number.
   * @throws ProductNotValidException if the product object does not meet the required validation
   *     criteria.
   */
  void create(Product product) throws SQLException, NotANumberException, ProductNotValidException;

  /**
   * Retrieves the count of products from the database.
   *
   * @return An Integer representing the count of products.
   * @throws SQLException if there is an error executing the database operation.
   */
  Integer count() throws SQLException;

  /**
   * Edits an existing product in the database.
   *
   * @param product The Product object representing the updated product information.
   * @throws SQLException if there is an error executing the database operation.
   * @throws ProductNotValidException if the product object does not meet the required validation
   *     criteria.
   */
  void edit(Product product) throws SQLException, ProductNotValidException;

  /**
   * Retrieves a list of products from the database with a specified page limit.
   *
   * @param pageLimit The page limit indicating the maximum number of products to retrieve.
   * @return An ArrayList of Product objects containing the retrieved products.
   * @throws NotANumberException if the provided page limit is not a valid number.
   */
  ArrayList<Product> listWithPageLimit(String pageLimit) throws NotANumberException;

  /**
   * Retrieves a list of products from the database with a specified page limit and page count.
   *
   * @param pageLimit The page limit indicating the maximum number of products to retrieve.
   * @param pageCount The page count indicating the current page number.
   * @return An ArrayList of Product objects containing the retrieved products.
   * @throws NotANumberException if the provided page limit or page count is not a valid number.
   */
  ArrayList<Product> listWithPageLimitAndPageCount(String pageLimit, String pageCount)
      throws NotANumberException;

  /**
   * Performs a global search for products based on the provided search value.
   *
   * @param searchValue The value to search for in the products.
   * @return An ArrayList of Product objects matching the search criteria.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<Product> globalSearch(String searchValue) throws SQLException;
}
