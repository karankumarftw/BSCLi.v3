package dao;

import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseItemDAO {
  String insert(int invoice, PurchaseItem purchaseItem) throws SQLException;

  ArrayList<PurchaseItem> list() throws SQLException;

  void delete(int invoice) throws SQLException;
}
