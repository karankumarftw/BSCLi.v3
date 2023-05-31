package dao;

import entity.Product;
import java.sql.SQLException;

public interface ProductCreate {
	/**
	 *
	 * @param object
	 * @return
	 * @throws SQLException
	 */
	String productCreate(Product object) throws SQLException;
}
