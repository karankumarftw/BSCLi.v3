package dao;

import entity.Purchase;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseDAOInterface {
  boolean createPurchase(Purchase purchase) throws SQLException;

  ArrayList<Purchase> purchaseList() throws SQLException;

  int purchaseCount() throws SQLException;

  int purchaseCountOnDate(String date) throws SQLException;

  String purchaseDelete(int invoice) throws SQLException;
}
