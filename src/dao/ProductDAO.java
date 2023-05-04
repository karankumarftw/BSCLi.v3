package dao;
import connection.DBConnection;
import interfaces.Delete;
import interfaces.defaultList;
import interfaces.ProductCreate;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ProductDAO implements ProductCreate, Delete , defaultList{
	@Override
	public String productCreate(Product proObj) throws SQLException {
		PreparedStatement ps = DBConnection.connection.prepareStatement("insert into products values(?,?,?,?,?,?)");
		ps.setInt(1,proObj.getCode());
		ps.setString(2, proObj.getName());
		ps.setString(3, proObj.getUnitCode());
		ps.setString(4, proObj.getType());
		ps.setDouble(5,proObj.getPrice());
		ps.setDouble(6,proObj.getStock());
		ps.executeUpdate();
		return "Product created successfully";
	}
	@Override
	public String delete(String code) throws SQLException {
		String query = "delete from products where code = "+code;
		DBConnection.statement.execute(query);
		return "Product deleted successfully";
	}

	@Override
	public ResultSet list() throws SQLException {
		String query = "select * from products";
		return DBConnection.statement.executeQuery(query);
	}
}
