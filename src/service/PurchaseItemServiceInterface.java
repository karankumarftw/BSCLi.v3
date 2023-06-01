package service;

import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseItemServiceInterface {
  void createNewPurchaseItems(int invoiceNo, ArrayList<PurchaseItem> purchaseItems)
      throws SQLException;

  ArrayList<PurchaseItem> purchaseItemsList() throws SQLException;

  void deletePurchaseItem(int invoice) throws SQLException;
}
