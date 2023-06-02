package service;

import dao.PurchaseItemDAOImplementation;
import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseItemServiceImplementation implements PurchaseItemService {
  private final PurchaseItemDAOImplementation purchaseItemDAO = new PurchaseItemDAOImplementation();

  public void create(int invoiceNo, ArrayList<PurchaseItem> purchaseItems)
      throws SQLException {

    for (PurchaseItem purchaseItem : purchaseItems) {
      purchaseItemDAO.insert(invoiceNo, purchaseItem);
    }
  }

  public ArrayList<PurchaseItem> purchaseItemsList() throws SQLException {
    return purchaseItemDAO.list();
  }

  public void delete(int invoice) throws SQLException {
    purchaseItemDAO.delete(invoice);
  }
}
