package dao;

import entity.Sales;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesDAO {
  /**
   * Records a sales transaction based on the provided Sales object.
   *
   * @param sales the Sales object representing the sales transaction to record
   * @throws SQLException if an error occurs during the recording process
   */
  void sales(Sales sales) throws SQLException;

  /**
   * Retrieves a list of sales transactions.
   *
   * @return an ArrayList containing the list of Sales objects representing the sales transactions
   */
  ArrayList<Sales> list();

  /**
   * Retrieves the count of sales transactions.
   *
   * @return the count of sales transactions
   * @throws SQLException if an error occurs while retrieving the count
   */
  int count() throws SQLException;

  /**
   * Retrieves the count of sales transactions that occurred on the specified date.
   *
   * @param date the date for which to retrieve the count of sales transactions
   * @return the count of sales transactions that occurred on the specified date
   * @throws SQLException if an error occurs while retrieving the count
   */
  int countOnDate(String date) throws SQLException;
}
