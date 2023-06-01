package dao;

import connection.DBConnection;
import entity.Purchase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseDAO implements PurchaseDAOInterface {
  public boolean createPurchase(Purchase purchase) throws SQLException {
    try {
      PreparedStatement ps =
          DBConnection.connection.prepareStatement(
              "INSERT INTO PURCHASE(DATE,INVOICE,GRAND_TOTAL) VALUES (?,?,?)");
      ps.setString(1, purchase.getDate());
      ps.setInt(2, purchase.getInvoice());
      ps.setDouble(3, purchase.getGrandTotal());
      ps.executeUpdate();
      return true;
    } catch (Exception e) {
      throw new SQLException("Invoice Number already exists kindly check the number");
    }
  }

  public ArrayList<Purchase> purchaseList() throws SQLException {
    ArrayList<Purchase> purchaseList = new ArrayList<>();
    ResultSet rs = DBConnection.statement.executeQuery("select * from purchase");
    while (rs.next()) {
      int purchaseID = rs.getInt("id");
      String purchaseDate = rs.getString("date");
      int invoice = rs.getInt("invoice");
      double grandTotal = rs.getDouble("grand_total");
      Purchase purchase = new Purchase(purchaseID, purchaseDate, invoice, grandTotal);
      purchaseList.add(purchase);
    }
    return purchaseList;
  }

  public int purchaseCount() throws SQLException {
    ResultSet rs = DBConnection.statement.executeQuery("SELECT COUNT(*) FROM PURCHASE");
    int count = 0;
    if (rs.next()) {
      count = rs.getInt("count");
    }
    return count;
  }

  public int purchaseCountOnDate(String date) throws SQLException {
    ResultSet rs =
        DBConnection.statement.executeQuery(
            "SELECT COUNT(*) FROM PURCHASE where date = '" + date + "'");
    int count = 0;
    if (rs.next()) {
      count = rs.getInt("count");
    }
    return count;
  }

  public String purchaseDelete(int invoice) throws SQLException {
    DBConnection.statement.execute("delete from purchase where invoice = " + invoice);
    return "Purchase deleted successfully";
  }
}
