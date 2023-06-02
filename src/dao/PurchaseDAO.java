package dao;

import entity.Purchase;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseDAO {
  boolean create(Purchase purchase) throws SQLException;

  ArrayList<Purchase> list() throws SQLException;

  int count() throws SQLException;

  int countOnDate(String date) throws SQLException;

  String delete(int invoice) throws SQLException;
}
