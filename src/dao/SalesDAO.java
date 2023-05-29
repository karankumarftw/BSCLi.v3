package dao;

import connection.DBConnection;
import entity.Purchase;
import entity.Sales;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDAO {
	public boolean createSales(Sales sales) throws SQLException {
		try {
			PreparedStatement ps =
					DBConnection.connection.prepareStatement(
							"insert into sales(date,invoice,grand_total) values (?,?,?)");
			ps.setString(1, sales.getDate());
			ps.setInt(2, sales.getInvoice());
			ps.setDouble(3, sales.getGrandTotal());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			throw new SQLException("Invoice Number already exists kindly check the number");
		}
	}
}
