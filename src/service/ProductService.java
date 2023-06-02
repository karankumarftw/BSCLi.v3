package service;

import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductService {
  String delete(String code) throws SQLException, NotANumberException;

  ArrayList<Product> list() throws SQLException;

  String create(Product product) throws SQLException, NotANumberException, ProductNotValidException;

  Integer count() throws SQLException;

  String edit(Product product) throws SQLException, ProductNotValidException;

  ArrayList<Product> listWithPageLimit(String pageLimit) throws NotANumberException;

  public ArrayList<Product> listWithPageLimitAndPageCount(String pageLimit, String pageCount)
      throws NotANumberException;

  ArrayList<Product> globalSearch(String searchValue) throws SQLException;
}
