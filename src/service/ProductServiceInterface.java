package service;

import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductServiceInterface {
  String productDelete(String code) throws SQLException, NotANumberException;

  ArrayList<Product> productList() throws SQLException;

  String productCreate(Product product) throws SQLException, NotANumberException, ProductNotValidException;

  Integer productCount() throws SQLException;

  String productEdit(Product product) throws SQLException, ProductNotValidException;

  ArrayList<Product> productListWithPageLimit(String pageLimit) throws NotANumberException;

  public ArrayList<Product> productListWithPageLimitAndPageCount(String pageLimit, String pageCount)
          throws NotANumberException;

  ArrayList<Product> globalSearch(String searchValue) throws SQLException;
}
