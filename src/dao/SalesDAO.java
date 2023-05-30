package dao;

import connection.DBConnection;
import entity.Sales;
import entity.SalesItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesDAO {
  private ResultSet rs;

  public boolean createSales(Sales sales) throws SQLException {
    try {
      PreparedStatement ps =
          DBConnection.connection.prepareStatement(
              "INSERT INTO SALES(DATE,INVOICE,GRAND_TOTAL) VALUES (?,?,?)");
      ps.setString(1, sales.getDate());
      ps.setInt(2, sales.getInvoice());
      ps.setDouble(3, sales.getGrandTotal());
      ps.executeUpdate();
      return true;
    } catch (Exception e) {
      throw new SQLException("Invoice Number already exists kindly check the number");
    }
  }



  public int salesCount() throws SQLException {
    String query = "SELECT COUNT(*) FROM SALES";
    rs = DBConnection.statement.executeQuery(query);
    int count = 0;
    if (rs.next()) {
      count = rs.getInt("count");
    }
    return count;
  }
  
  public int salesCountOnDate(String date) throws SQLException {
    String query = "select count(*) from sales where date = '"+date+"'";
    rs = DBConnection.statement.executeQuery(query);
    int count = 0;
    if (rs.next()) {
      count = rs.getInt("count");
    }
    return count;
  }
  
  
}
