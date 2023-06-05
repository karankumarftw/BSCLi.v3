package service;

import entity.SalesItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesItemService {
  /**
   * Creates a new sales record with the specified invoice number and sales items.
   *
   * @param invoiceNo The invoice number for the new sales record.
   * @param salesItems The list of SalesItem objects representing the sales items for the record.
   * @throws SQLException if there is an error executing the database operation.
   */
  void create(int invoiceNo, ArrayList<SalesItem> salesItems) throws SQLException;

  /**
   * Retrieves a list of sales items from the database.
   *
   * @return An ArrayList of SalesItem objects containing the retrieved sales items.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<SalesItem> salesItemList() throws SQLException;
}
