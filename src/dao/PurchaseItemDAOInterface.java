package dao;

import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseItemDAOInterface {
  String insertPurchaseItem(int invoice, PurchaseItem purchaseItem) throws SQLException;

  ArrayList<PurchaseItem> purchaseItemsList() throws SQLException;

  void deletePurchaseItem(int invoice) throws SQLException;
}
