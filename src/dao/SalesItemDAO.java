package dao;

import connection.DBConnection;
import entity.SalesItem;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesItemDAO {
  public String insertSalesItem(int invoice, SalesItem salesItem) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(
            "INSERT INTO SALES_ITEMS (INVOICE,CODE,QUANTITY,PRICE) VALUES(?,?,?,?)");

    ps.setInt(1, invoice);
    ps.setInt(2, salesItem.getCode());
    ps.setDouble(3, salesItem.getQuantity());
    ps.setDouble(4, salesItem.getItemPrice());
    ps.executeUpdate();
    return "Sale Item inserted successfully. CODE : " + salesItem.getCode();
  }
}
