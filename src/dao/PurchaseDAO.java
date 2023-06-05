package dao;

import entity.Purchase;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseDAO {

  /**
   * Creates a new purchase record based on the provided Purchase object.
   *
   * @param purchase the Purchase object representing the purchase to create
   * @throws SQLException if an error occurs during the creation process
   */
  void create(Purchase purchase) throws SQLException;

  /**
   * Retrieves a list of Purchase objects.
   *
   * @return an ArrayList containing the list of Purchase objects
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<Purchase> list() throws SQLException;

  /**
   * Retrieves the count of purchases.
   *
   * @return the count of purchases
   * @throws SQLException if an error occurs while retrieving the count
   */
  int count() throws SQLException;

  /**
   * Retrieves the count of purchases made on the specified date.
   *
   * @param date the date for which to retrieve the count of purchases
   * @return the count of purchases made on the specified date
   * @throws SQLException if an error occurs while retrieving the count
   */
  int countOnDate(String date) throws SQLException;

  /**
   * Deletes the purchase record with the specified invoice number.
   *
   * @param invoice the invoice number of the purchase record to be deleted
   * @return a String representing the result of the operation
   * @throws SQLException if an error occurs during the deletion process
   */
  Integer delete(int invoice) throws SQLException;
}
