package service;

import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseItemService {
  void create(int invoiceNo, ArrayList<PurchaseItem> purchaseItems)
      throws SQLException;

  ArrayList<PurchaseItem> purchaseItemsList() throws SQLException;

  void delete(int invoice) throws SQLException;
}
