package dao;

import entity.Sales;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesDAOInterface {
  boolean createSales(Sales sales) throws SQLException;

  ArrayList<Sales> salesList();

  int salesCount() throws SQLException;

  int salesCountOnDate(String date) throws SQLException;
}
