package dao;

import entity.Product;
import java.sql.SQLException;

public interface ProductCreate {
	String productCreate(Product object) throws SQLException;
}
