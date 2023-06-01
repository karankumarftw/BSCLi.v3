package service;

import dao.SalesDAO;
import entity.Sales;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesService implements SalesServiceInterface {

  private SalesDAO salesDAO = new SalesDAO();

  public String newSales(Sales sales) throws SQLException {

    boolean successOrFail = salesDAO.createSales(sales);

    if (successOrFail) {
      return "New sale is successful";
    }
    return "Sales failed";
  }

  public int salesCount() throws SQLException {
    return salesDAO.salesCount();
  }

  public int salesCountOnDate(String date) throws SQLException {
    return salesDAO.salesCountOnDate(date);
  }

  public ArrayList<Sales> salesList() {
    return salesDAO.salesList();
  }
}
