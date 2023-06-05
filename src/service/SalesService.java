package service;

import entity.Sales;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesService {
  /**
   * Creates a new sales record in the database.
   *
   * @param sales The Sales object representing the sales record to be created.
   * @throws SQLException if there is an error executing the database operation.
   */
  void create(Sales sales) throws SQLException;

  /**
   * Retrieves the count of sales records from the database.
   *
   * @return An integer representing the count of sales records.
   * @throws SQLException if there is an error executing the database operation.
   */
  int count() throws SQLException;

  /**
   * Retrieves the count of sales records on the specified date from the database.
   *
   * @param date The date for which to retrieve the sales record count.
   * @return An integer representing the count of sales records on the specified date.
   * @throws SQLException if there is an error executing the database operation.
   */
  int countOnDate(String date) throws SQLException;

  /**
   * Retrieves a list of sales records from the database.
   *
   * @return An ArrayList of Sales objects containing the retrieved sales records.
   */
  ArrayList<Sales> list();
}
