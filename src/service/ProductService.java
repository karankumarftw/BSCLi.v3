package service;

import dao.ProductDAO;
import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService implements ProductServiceInterface{
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

  public Integer productCount() throws SQLException {
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

  public ArrayList<Product> globalSearch(String searchValue) throws SQLException {
    return productDAO.globalSearch(searchValue);
  }

  public double getItemPrice(int code) throws SQLException {

    return productDAO.getItemPrice(code);
  }

  public ArrayList<Product> searchWithAttribute(String attr, String searchValue)
      throws SQLException {

    return productDAO.searchWithAttribute(attr, searchValue);
  }

  public ArrayList<Product> searchWithAttributeWithPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException {
    return productDAO.searchWithAttributeWithPaging(attr, searchValue, pageLimit, pageCount);
  }
}