package service;

import dao.SalesDAOImplementation;
import entity.Sales;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesServiceImplementation implements SalesService {

  private final SalesDAOImplementation salesDAO = new SalesDAOImplementation();

  public void create(Sales sales) throws SQLException {
    salesDAO.sales(sales);
  }

  public int count() throws SQLException {
    return salesDAO.count();
  }

  public int countOnDate(String date) throws SQLException {
    return salesDAO.countOnDate(date);
  }

  public ArrayList<Sales> list() {
    return salesDAO.list();
  }
}
