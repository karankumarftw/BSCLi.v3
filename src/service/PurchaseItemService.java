package service;

import dao.PurchaseItemDAO;
import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseItemService implements PurchaseItemServiceInterface {
  private PurchaseItemDAO purchaseItemDAO = new PurchaseItemDAO();

  public void createNewPurchaseItems(int invoiceNo, ArrayList<PurchaseItem> purchaseItems)
      throws SQLException {

    for (PurchaseItem purchaseItem : purchaseItems) {
      purchaseItemDAO.insertPurchaseItem(invoiceNo, purchaseItem);
    }
  }

  public ArrayList<PurchaseItem> purchaseItemsList() throws SQLException {
    return purchaseItemDAO.purchaseItemsList();
  }

  public void deletePurchaseItem(int invoice) throws SQLException {
    purchaseItemDAO.deletePurchaseItem(invoice);
  }
}
