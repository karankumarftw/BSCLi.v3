package dao;

import connection.DBConnection;
import entity.Sales;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesDAOImplementation implements SalesDAO {
  private ResultSet rs;

  public void sales(Sales sales) throws SQLException {
    try {
      PreparedStatement ps =
          DBConnection.connection.prepareStatement(
              "INSERT INTO SALES(DATE,INVOICE,GRAND_TOTAL) VALUES (?,?,?)");
      ps.setString(1, sales.getDate());
      ps.setInt(2, sales.getInvoice());
      ps.setDouble(3, sales.getGrandTotal());
      ps.executeUpdate();
    } catch (Exception e) {
      throw new SQLException("Invoice Number already exists kindly check the number");
    }
  }

  public ArrayList<Sales> list() {
    ArrayList<Sales> sales1 = new ArrayList();
    try {
      ResultSet rs = DBConnection.statement.executeQuery("select * from sales");
      while (rs.next()) {
        int salesID = rs.getInt("id");
        String salesDate = rs.getString("date");
        int invoice = rs.getInt("invoice");
        double grandTotal = rs.getDouble("grand_total");
        Sales sales = new Sales(salesID, salesDate, invoice, grandTotal);
        sales1.add(sales);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return sales1;
  }

  public int count() throws SQLException {
    String query = "SELECT COUNT(*) FROM SALES";
    rs = DBConnection.statement.executeQuery(query);
    int count = 0;
    if (rs.next()) {
      count = rs.getInt("count");
    }
    return count;
  }

  public int countOnDate(String date) throws SQLException {
    String query = "select count(*) from sales where date = '" + date + "'";
    rs = DBConnection.statement.executeQuery(query);
    int count = 0;
    if (rs.next()) {
      count = rs.getInt("count");
    }
    return count;
  }

  // public salesDelete()
}
