package service;

import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseItemService {
  /**
   * Creates a new invoice with the specified invoice number and purchase items.
   *
   * @param invoiceNo The invoice number for the new invoice.
   * @param purchaseItems The list of PurchaseItem objects representing the purchase items for the
   *     invoice.
   * @throws SQLException if there is an error executing the database operation.
   */
  void create(int invoiceNo, ArrayList<PurchaseItem> purchaseItems) throws SQLException;

  /**
   * Retrieves a list of purchase items from the database.
   *
   * @return An ArrayList of PurchaseItem objects containing the retrieved purchase items.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<PurchaseItem> purchaseItemsList() throws SQLException;

  /**
   * Deletes the invoice with the specified invoice number from the database.
   *
   * @param invoice The invoice number to be deleted.
   * @throws SQLException if there is an error executing the database operation.
   */
  void delete(int invoice) throws SQLException;
}
