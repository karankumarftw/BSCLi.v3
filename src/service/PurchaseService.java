package service;

import dao.PurchaseDAO;
import entity.Purchase;
import java.sql.SQLException;

public class PurchaseService {
  private PurchaseDAO purchaseDAO = new PurchaseDAO();

  public String newPurchase(Purchase purchase) throws SQLException {

    boolean successOrFail = purchaseDAO.createPurchase(purchase);

    if (successOrFail) {
      return "New purchase is successful";
    }
    return "Purchase failed";
  }

  public int purchaseCount() throws SQLException {

    return purchaseDAO.purchaseCount();
  }
}
