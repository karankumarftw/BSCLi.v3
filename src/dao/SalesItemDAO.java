package dao;

import entity.SalesItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesItemDAO {

  /**
   * Inserts a new sales item record into the database with the specified invoice number and
   * SalesItem object.
   *
   * @param invoice the invoice number of the sales
   * @param salesItem the SalesItem object representing the sold item
   * @throws SQLException if an error occurs during the insertion process
   */
  void insert(int invoice, SalesItem salesItem) throws SQLException;

  /**
   * Retrieves a list of sales items.
   *
   * @return an ArrayList containing the list of SalesItem objects representing the sales items
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<SalesItem> list() throws SQLException;
}
