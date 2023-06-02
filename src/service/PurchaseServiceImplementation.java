package service;

import dao.PurchaseDAOImplementation;
import entity.Purchase;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseServiceImplementation implements PurchaseService {
  private final PurchaseDAOImplementation purchaseDAO = new PurchaseDAOImplementation();

  public void create(Purchase purchase) throws SQLException {

    boolean successOrFail = purchaseDAO.create(purchase);

    if (successOrFail) {
    }
  }

  public ArrayList<Purchase> purchaseList() throws SQLException {
    return purchaseDAO.list();
  }

  public Integer purchaseCount() throws SQLException {

    return purchaseDAO.count();
  }

  public Integer purchaseCountOnDate(String date) throws SQLException {
    return purchaseDAO.countOnDate(date);
  }

  @Override
  public String purchaseDelete(Integer invoice) throws SQLException {
    return purchaseDAO.delete(invoice);
  }
}
