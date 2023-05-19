package dao;

import connection.DBConnection;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO implements ProductCreate, Delete {

	public String productCreate(Product proObj) throws SQLException {
		PreparedStatement ps =
				DBConnection.connection.prepareStatement("insert into products values(?,?,?,?,?,?)");
		ps.setInt(1, proObj.getCode());
		ps.setString(2, proObj.getName());
		ps.setString(3, proObj.getUnitCode());
		ps.setString(4, proObj.getType());
		ps.setDouble(5, proObj.getPrice());
		ps.setDouble(6, proObj.getStock());
		ps.executeUpdate();
		return "Product created successfully";
	}

	public String productEdit(Product proObj) throws SQLException {
		PreparedStatement ps =
				DBConnection.connection.prepareStatement(
						"update products set name = ?, unit = ?, type = ?, price = ?, stock = ? where code = ? ");
		ps.setString(1, proObj.getName());
		ps.setString(2, proObj.getUnitCode());
		ps.setString(3, proObj.getType());
		ps.setDouble(4, proObj.getPrice());
		ps.setDouble(5, proObj.getStock());
		ps.setInt(6, proObj.getCode());
		ps.executeUpdate();
		return "Product created successfully";
	}

	public String delete(String data) throws SQLException {
		String query = "delete from products where code = " + data;
		DBConnection.statement.execute(query);
		return "Product deleted successfully";
	}

	private ArrayList<Product> results(String query) throws SQLException {
		ArrayList<Product> listOfProducts = new ArrayList<>();
		ResultSet rs = DBConnection.statement.executeQuery(query);
		while (rs.next()) {
			int code = rs.getInt("code");
			String name = rs.getString("product_name");
			String unit = rs.getString("unit_code");
			String type = rs.getString("product_type");
			double price = rs.getDouble("product_price");
			double stock = rs.getDouble("stock");
			Product product = new Product(code, name, unit, type, price, stock);
			listOfProducts.add(product);
		}
		return listOfProducts;
	}

	public int count() throws SQLException {
		ResultSet rs = DBConnection.statement.executeQuery("select count(*) from products");
		int count = 0;
		if (rs.next()) {
			count = rs.getInt("count");
		}
		return count;
	}

	public ArrayList<Product> list() throws SQLException {
		String query = "select * from products order by code limit 20";
		return results(query);
	}

	public ArrayList<Product> listWithPageLimit(int limitCount) throws SQLException {
		String query = "select * from products order by code limit " + limitCount;
		return results(query);
	}

	public ArrayList<Product> listWithPageLimitAndPageCount(int pageLimit, int pageCount) throws SQLException {
		int offset;
		if (pageCount == 1) {
			offset = 0;
		} else {
			offset = (pageCount - 1) * pageLimit;
		}
		String query =
				"select * from products order by code asc offset " + offset + "  limit " + pageLimit;
		return results(query);
	}
}