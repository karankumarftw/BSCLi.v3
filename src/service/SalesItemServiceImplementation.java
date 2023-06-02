package service;

import dao.SalesItemDAOImplementation;
import entity.SalesItem;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesItemServiceImplementation implements SalesItemService {
  private final SalesItemDAOImplementation salesItemDAO = new SalesItemDAOImplementation();

  public void create(int invoiceNo, ArrayList<SalesItem> salesItems)
      throws SQLException {

    for (SalesItem salesItem : salesItems) {
      salesItemDAO.insert(invoiceNo, salesItem);
    }
  }

  public ArrayList<SalesItem> salesItemList() throws SQLException {
    return salesItemDAO.list();
  }
}
