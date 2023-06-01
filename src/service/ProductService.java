package service;

import dao.ProductDAO;
import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService implements ProductServiceInterface {
  ProductDAO productDAO = new ProductDAO();
  ProductValidator productValidator = new ProductValidator();

  public String productDelete(String code) throws NotANumberException {
    try {
      return productDAO.delete(code);
    } catch (Exception e) {
      throw new NotANumberException("Product code should be a number");
    }
  }

  public ArrayList<Product> productList() throws SQLException {
    return productDAO.list();
  }

  public String productCreate(Product product) throws ProductNotValidException {
    try {
      productValidator.productValidator(product);
      return productDAO.productCreate(product);
    } catch (Exception e) {
      throw new ProductNotValidException(e.getMessage());
    }
  }

  public Integer productCount() throws SQLException {
    return productDAO.count();
  }

  public String productEdit(Product product) throws ProductNotValidException {
    try {
      productValidator.productValidator(product);
      return productDAO.productEdit(product);
    } catch (Exception e) {
      throw new ProductNotValidException(e.getMessage());
    }
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

  public String productPriceUpdate(String productCode, String newPrice) throws NotANumberException {
    try {
      int code = Integer.parseInt(productCode);
      double price = Double.parseDouble(newPrice);
      return productDAO.productPriceUpdate(code, price);
    } catch (Exception e) {
      throw new NotANumberException("Code and price should be numeric values");
    }
  }

  public String productStockUpdate(String productCode, String newStock) throws NotANumberException {
    try {
      int code = Integer.parseInt(productCode);
      double stock = Double.parseDouble(newStock);
      return productDAO.productStockUpdate(code, stock);
    } catch (Exception e) {
      throw new NotANumberException("Code and stock should be numeric values");
    }
  }
}