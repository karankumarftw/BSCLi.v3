package service;

import entity.Purchase;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseService {

  /**
   * Creates a new purchase in the database.
   *
   * @param purchase The Purchase object representing the purchase to be created.
   * @throws SQLException if there is an error executing the database operation.
   */
  void create(Purchase purchase) throws SQLException;

  /**
   * Retrieves a list of purchases from the database.
   *
   * @return An ArrayList of Purchase objects containing the retrieved purchases.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<Purchase> purchaseList() throws SQLException;

  /**
   * Retrieves the count of purchases from the database.
   *
   * @return An Integer representing the count of purchases.
   * @throws SQLException if there is an error executing the database operation.
   */
  Integer purchaseCount() throws SQLException;

  /**
   * Retrieves the count of purchases on the specified date from the database.
   *
   * @param date The date for which to retrieve the purchase count.
   * @return An Integer representing the count of purchases on the specified date.
   * @throws SQLException if there is an error executing the database operation.
   */
  Integer purchaseCountOnDate(String date) throws SQLException;

  /**
   * Deletes the purchase with the specified invoice number from the database.
   *
   * @param invoice The invoice number of the purchase to be deleted.
   * @return A string indicating the result of the deletion process.
   * @throws SQLException if there is an error executing the database operation.
   */
  Integer purchaseDelete(Integer invoice) throws SQLException;
}
