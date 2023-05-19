package service;

import dao.ProductDAO;
import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService {
  ProductDAO productDAO = new ProductDAO();

  public String productDelete(String code) throws SQLException, NotANumberException {
    try {
      return productDAO.delete(code);
    } catch (Exception e) {
      throw new NotANumberException("Product code should be a number");
    }
  }

  public ArrayList<Product> productList() throws SQLException {
    return productDAO.list();
  }

  public String productCreate(Product product) throws SQLException {
    return productDAO.productCreate(product);
  }

  public int productCount() throws SQLException {
    return productDAO.count();
  }

  public String productEdit(Product product) throws SQLException {
    return productDAO.productEdit(product);
  }

  public ArrayList<Product> productListWithPageLimit(String pageLimit) throws NotANumberException {
    try {
      return productDAO.listWithPageLimit(Integer.parseInt(pageLimit));
    } catch (Exception e) {
      throw new NotANumberException("Page count should be a number");
    }
  }

  public ArrayList<Product> productListWithPageLimitAndPageCount(String pageLimit, String pageCount)
      throws NotANumberException {
    try {
      return productDAO.listWithPageLimitAndPageCount(
          Integer.parseInt(pageLimit), Integer.parseInt(pageCount));
    } catch (Exception e) {
      throw new NotANumberException("Page Count and Page number should be numbers");
    }
  }
}
