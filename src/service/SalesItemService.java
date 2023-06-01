package service;

import dao.SalesItemDAO;
import entity.SalesItem;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesItemService implements SalesItemServiceInterface {
  private final SalesItemDAO salesItemDAO = new SalesItemDAO();

  public void createNewSalesItems(int invoiceNo, ArrayList<SalesItem> salesItems)
      throws SQLException {

    for (SalesItem salesItem : salesItems) {
      salesItemDAO.insertSalesItem(invoiceNo, salesItem);
    }
  }

  public ArrayList<SalesItem> salesItemList() throws SQLException {
    return salesItemDAO.salesItemsList();
  }
}
