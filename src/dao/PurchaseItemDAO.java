package dao;

import connection.DBConnection;
import entity.PurchaseItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseItemDAO implements PurchaseItemDAOInterface {
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

  public ArrayList<PurchaseItem> purchaseItemsList() throws SQLException {
    ArrayList<PurchaseItem> purchaseItemList = new ArrayList<>();
    ResultSet rs = DBConnection.statement.executeQuery("select * from purchase_items");
    while (rs.next()) {
      int invoice = rs.getInt("invoice");
      int code = rs.getInt("code");
      double quantity = rs.getDouble("quantity");
      double costPrice = rs.getDouble("cost_price");
      PurchaseItem purchaseItem = new PurchaseItem(invoice, code, quantity, costPrice);
      purchaseItemList.add(purchaseItem);
    }
    return purchaseItemList;
  }

  public void deletePurchaseItem(int invoice) throws SQLException {
    DBConnection.statement.execute("delete from purchase_items where invoice = " + invoice);
  }
}
