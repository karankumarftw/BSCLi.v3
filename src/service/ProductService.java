package service;

import dao.ProductDAO;
import entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductService {
  ProductDAO productDAO = new ProductDAO();

  public String productDelete(String code) throws SQLException {
    return productDAO.delete(code);
  }

  public ResultSet productList() throws SQLException {
    return productDAO.list();
  }

  public String productCreate(Product product) throws SQLException {
    return productDAO.productCreate(product);
  }

  public String productEdit(Product product) throws SQLException {
    return productDAO.productEdit(product);
  }

  public ResultSet productListWithPageLimit(String pageLimit) throws SQLException {
    return productDAO.listWithPageLimit(Integer.parseInt(pageLimit));
  }

  public ResultSet productListWithPageLimitAndPageCount(String pageLimit, String pageCount)
      throws SQLException {
    return productDAO.listWithPageLimitAndPageCount(
        Integer.parseInt(pageLimit), Integer.parseInt(pageCount));
  }
}
