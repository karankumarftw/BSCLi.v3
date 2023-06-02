package dao;

import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
  String create(Product proObj) throws SQLException;

  String edit(Product proObj) throws SQLException;

  String delete(String data) throws SQLException;

  int count() throws SQLException;

  ArrayList<Product> list() throws SQLException;

  ArrayList<Product> listWithPageLimit(int limitCount) throws SQLException;

  ArrayList<Product> listWithPageLimitAndPageCount(int pageLimit, int pageCount)
      throws SQLException;

  ArrayList<Product> globalSearch(String searchValue) throws SQLException;

  ArrayList<Product> searchWithAttribute(String attr, String searchValue) throws SQLException;

  ArrayList<Product> searchWithAttributeAndPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException;

  double getItemPrice(int code) throws SQLException;

  String priceUpdate(int code, double price) throws SQLException;

  String stockUpdate(int code, double stock) throws SQLException;
}
