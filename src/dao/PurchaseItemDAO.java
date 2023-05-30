package dao;

import connection.DBConnection;
import entity.PurchaseItem;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseItemDAO {
  public String insertPurchaseItem(int invoice, PurchaseItem purchaseItem) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(
            "INSERT INTO PURCHASE_ITEMS(INVOICE,CODE,QUANTITY,COST_PRICE) VALUES(?,?,?,?)");

    ps.setInt(1, invoice);
    ps.setInt(2, purchaseItem.getCode());
    ps.setDouble(3, purchaseItem.getQuantity());
    ps.setDouble(4, purchaseItem.getCostPrice());
    ps.executeUpdate();
    return "Purchased Item inserted successfully. CODE : " + purchaseItem.getCode();
  }

  public void deletePurchaseItem(int invoice) throws SQLException {
    DBConnection.statement.execute("delete from purchase_items where invoice = " + invoice);
  }
}
