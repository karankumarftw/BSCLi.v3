package service;

import entity.SalesItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesItemServiceInterface {
  void createNewSalesItems(int invoiceNo, ArrayList<SalesItem> salesItems) throws SQLException;

  ArrayList<SalesItem> salesItemList() throws SQLException;
}
