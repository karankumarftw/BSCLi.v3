package dao;

import connection.DBConnection;
import entity.SalesItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesItemDAOImplementation implements SalesItemDAO {
  public void insert(int invoice, SalesItem salesItem) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(
            "INSERT INTO SALES_ITEMS (INVOICE,CODE,QUANTITY,PRICE) VALUES(?,?,?,?)");
    ps.setInt(1, invoice);
    ps.setInt(2, salesItem.getCode());
    ps.setDouble(3, salesItem.getQuantity());
    ps.setDouble(4, salesItem.getItemPrice());
    ps.executeUpdate();
  }

  public ArrayList<SalesItem> list() throws SQLException {
    ArrayList<SalesItem> salesItems = new ArrayList<>();
    ResultSet rs = DBConnection.statement.executeQuery("select * from sales_items");
    while (rs.next()) {
      int invoice = rs.getInt("invoice");
      int code = rs.getInt("code");
      double quantity = rs.getDouble("quantity");
      double price = rs.getDouble("price");
      SalesItem salesItem = new SalesItem(invoice, code, quantity, price);
      salesItems.add(salesItem);
    }
    return salesItems;
  }
}
