package service;
import dao.ProductDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ProductService {
	public String productDelete(String code) throws SQLException {
		ProductDAO productDAO = new ProductDAO();
		return productDAO.delete(code);
	}
	public  ResultSet productList() throws SQLException {
		ProductDAO productDAO = new ProductDAO();
		return productDAO.list();
	}
}
