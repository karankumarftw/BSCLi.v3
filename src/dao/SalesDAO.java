package dao;

import entity.Sales;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesDAO {
  boolean sales(Sales sales) throws SQLException;

  ArrayList<Sales> list();

  int count() throws SQLException;

  int countOnDate(String date) throws SQLException;
}
