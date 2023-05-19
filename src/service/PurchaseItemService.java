package service;

import dao.PurchaseItemDAO;
import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseItemService {
  public void createNewPurchaseItems(int invoiceNo, ArrayList<PurchaseItem> purchaseItems)
      throws SQLException {
    PurchaseItemDAO purchaseItemDAO = new PurchaseItemDAO();
    for (PurchaseItem purchaseItem : purchaseItems) {
      purchaseItemDAO.insertPurchaseItem(invoiceNo, purchaseItem);
    }

  }
}
