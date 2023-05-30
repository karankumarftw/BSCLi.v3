package service;

import connection.DBConnection;
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

  public int purchaseOnDate(String date) throws SQLException{
    return purchaseDAO.purchaseCountOnDate(date);
  }

  public String purchaseDelete(int invoice) throws SQLException {
    return purchaseDAO.purchaseDelete(invoice);
  }
}
