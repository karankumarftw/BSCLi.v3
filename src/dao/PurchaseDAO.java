package dao;

import connection.DBConnection;
import entity.Purchase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseDAO {
  public boolean createPurchase(Purchase purchase) throws SQLException {
    try {
      PreparedStatement ps =
          DBConnection.connection.prepareStatement(
              "insert into purchase(date,invoice,grand_total) values (?,?,?)");
      ps.setString(1, purchase.getDate());
      ps.setInt(2, purchase.getInvoice());
      ps.setDouble(3, purchase.getGrandTotal());
      ps.executeUpdate();
      return true;
    } catch (Exception e) {
      throw new SQLException("Invoice Number already exists kindly check the number");
    }
  }

  public int purchaseCount() throws SQLException {
    ResultSet rs = DBConnection.statement.executeQuery("select count(*) from purchase");
    int count = 0;
    if(rs.next()){
      count = rs.getInt("count");
    }
    return count;
  }
}
