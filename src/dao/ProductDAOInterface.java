package dao;

import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAOInterface {
  String productCreate(Product proObj) throws SQLException;

  String productEdit(Product proObj) throws SQLException;

  String delete(String data) throws SQLException;

  int count() throws SQLException;

  ArrayList<Product> list() throws SQLException;

  ArrayList<Product> listWithPageLimit(int limitCount) throws SQLException;

  ArrayList<Product> listWithPageLimitAndPageCount(int pageLimit, int pageCount)
      throws SQLException;

  ArrayList<Product> globalSearch(String searchValue) throws SQLException;

  ArrayList<Product> searchWithAttribute(String attr, String searchValue) throws SQLException;

  ArrayList<Product> searchWithAttributeWithPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException;

  double getItemPrice(int code) throws SQLException;

  String productPriceUpdate(int code, double price) throws SQLException;

  String productStockUpdate(int code, double stock) throws SQLException;
}
