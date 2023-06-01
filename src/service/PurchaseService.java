package service;

import connection.DBConnection;
import dao.PurchaseDAO;
import entity.Purchase;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseService implements PurchaseServiceInterface {
  private PurchaseDAO purchaseDAO = new PurchaseDAO();

  public String newPurchase(Purchase purchase) throws SQLException {

    boolean successOrFail = purchaseDAO.createPurchase(purchase);

    if (successOrFail) {
      return "New purchase is successful";
    }
    return "Purchase failed";
  }

  public ArrayList<Purchase> purchaseList() throws SQLException {
    return purchaseDAO.purchaseList();
  }

  public int purchaseCount() throws SQLException {

    return purchaseDAO.purchaseCount();
  }

  public int purchaseCountOnDate(String date) throws SQLException{
    return purchaseDAO.purchaseCountOnDate(date);
  }

  public String purchaseDelete(int invoice) throws SQLException {
    return purchaseDAO.purchaseDelete(invoice);
  }
}
