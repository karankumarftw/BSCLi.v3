package modules.product;
import dao.ProductDAO;
import entity.Product;
import java.sql.SQLException;
public class ProductCreateWithAttributes {
	public static String create(int productCode, String productName, String unit, String type, double price, double stock) throws SQLException {
		Product product = new Product(productCode,productName,unit,type,price,stock);
		ProductDAO productDAO = new ProductDAO();
		return productDAO.productCreate(product);
	}
}