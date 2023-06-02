package service;

import entity.SalesItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesItemService {
  void create(int invoiceNo, ArrayList<SalesItem> salesItems) throws SQLException;

  ArrayList<SalesItem> salesItemList() throws SQLException;
}
