package dao;

import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseItemDAO {

  /**
   * Inserts a new purchase item record into the database with the specified invoice number and
   * PurchaseItem object.
   *
   * @param invoice the invoice number of the purchase
   * @param purchaseItem the PurchaseItem object representing the purchased item
   * @throws SQLException if an error occurs during the insertion process
   */
  void insert(int invoice, PurchaseItem purchaseItem) throws SQLException;

  /**
   * Retrieves a list of PurchaseItem objects.
   *
   * @return an ArrayList containing the list of PurchaseItem objects
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<PurchaseItem> list() throws SQLException;

  /**
   * Deletes the purchase items associated with the specified invoice number.
   *
   * @param invoice the invoice number of the purchase items to be deleted
   * @throws SQLException if an error occurs during the deletion process
   */
  void delete(int invoice) throws SQLException;
}
