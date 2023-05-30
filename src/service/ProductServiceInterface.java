package service;

import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductServiceInterface {
  public String productDelete(String code) throws SQLException, NotANumberException;

  public ArrayList<Product> productList() throws SQLException;

  public String productCreate(Product product) throws SQLException ;

  public Integer productCount() throws SQLException;

  public String productEdit(Product product) throws SQLException;

  public ArrayList<Product> productListWithPageLimit(String pageLimit) throws NotANumberException;

  public ArrayList<Product> productListWithPageLimitAndPageCount(String pageLimit, String pageCount)
      throws NotANumberException;

  public ArrayList<Product> globalSearch(String searchValue) throws SQLException;
}
