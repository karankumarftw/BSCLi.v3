package service;

import dao.PurchaseItemDAO;
import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseItemService {
  private PurchaseItemDAO purchaseItemDAO = new PurchaseItemDAO();

  public void createNewPurchaseItems(int invoiceNo, ArrayList<PurchaseItem> purchaseItems)
      throws SQLException {

    for (PurchaseItem purchaseItem : purchaseItems) {
      purchaseItemDAO.insertPurchaseItem(invoiceNo, purchaseItem);
    }
  }

  public void deletePurchaseItem(int invoice) throws SQLException {
    purchaseItemDAO.deletePurchaseItem(invoice);
  }
}