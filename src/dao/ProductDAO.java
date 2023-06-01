package dao;

import connection.DBConnection;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO implements ProductDAOInterface {

  public String productCreate(Product proObj) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement("insert into products values(?,?,?,?,?,?)");
    ps.setInt(1, proObj.getCode());
    ps.setString(2, proObj.getName());
    ps.setString(3, proObj.getUnitCode());
    ps.setString(4, proObj.getType());
    ps.setDouble(5, proObj.getPrice());
    ps.setDouble(6, proObj.getStock());
    ps.executeUpdate();
    return "Product created successfully";
  }

  public String productEdit(Product proObj) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(
            "update products set name = ?, unit = ?, type = ?, price = ?, stock = ? where code = ? ");
    ps.setString(1, proObj.getName());
    ps.setString(2, proObj.getUnitCode());
    ps.setString(3, proObj.getType());
    ps.setDouble(4, proObj.getPrice());
    ps.setDouble(5, proObj.getStock());
    ps.setInt(6, proObj.getCode());
    ps.executeUpdate();
    return "Product created successfully";
  }

  public String delete(String data) throws SQLException {
    String query = "update products set is_deleted = true where code =" + data;
    DBConnection.statement.execute(query);
    return "Product deleted successfully";
  }

  private ArrayList<Product> results(String query) throws SQLException {
    ArrayList<Product> listOfProducts = new ArrayList<>();
    ResultSet rs = DBConnection.statement.executeQuery(query);
    while (rs.next()) {
      int code = rs.getInt("code");
      String name = rs.getString("product_name");
      String unit = rs.getString("unit_code");
      String type = rs.getString("product_type");
      double price = rs.getDouble("product_price");
      double stock = rs.getDouble("stock");
      Product product = new Product(code, name, unit, type, price, stock);
      listOfProducts.add(product);
    }
    return listOfProducts;
  }

  public int count() throws SQLException {
    ResultSet rs = DBConnection.statement.executeQuery("select count(*) from products");
    int count = 0;
    if (rs.next()) {
      count = rs.getInt("count");
    }
    return count;
  }

  public ArrayList<Product> list() throws SQLException {
    String query = "SELECT * FROM PRODUCTS ORDER BY CODE LIMIT 20";
    return results(query);
  }

  public ArrayList<Product> listWithPageLimit(int limitCount) throws SQLException {
    String query = "SELECT * FROM PRODUCTS ORDER BY CODE LIMIT " + limitCount;
    return results(query);
  }

  public ArrayList<Product> listWithPageLimitAndPageCount(int pageLimit, int pageCount)
      throws SQLException {
    int offset;
    if (pageCount == 1) {
      offset = 0;
    } else {
      offset = (pageCount - 1) * pageLimit;
    }
    String query =
        "SELECT * FROM PRODUCTS ORDER BY CODE ASC OFFSET " + offset + "  LIMIT " + pageLimit;
    return results(query);
  }

  public ArrayList<Product> globalSearch(String searchValue) throws SQLException {
    String query =
        "SELECT * FROM PRODUCTS WHERE UNIT_CODE ILIKE '%"
            + searchValue
            + "%' OR PRODUCT_TYPE ILIKE '%"
            + searchValue
            + "%' OR PRODUCT_NAME ILIKE '%"
            + searchValue
            + "%' OR UNIT_CODE ILIKE '%"
            + searchValue
            + "%' ";
    return results(query);
  }

  public ArrayList<Product> searchWithAttribute(String attr, String searchValue)
      throws SQLException {
    String query = "select * from products where '" + attr + "' = '" + searchValue + "'";
    return results(query);
  }

  public ArrayList<Product> searchWithAttributeWithPaging(
      String attr, String searchValue, int pageLimit, int pageCount) throws SQLException {
    int offset;
    if (pageCount == 1) {
      offset = 0;
    } else {
      offset = (pageCount - 1) * pageLimit;
    }
    String query =
        "select * from products where '"
            + attr
            + "' = '"
            + searchValue
            + "' ORDER BY CODE ASC OFFSET "
            + offset
            + "  LIMIT "
            + pageLimit;
    return results(query);
  }

  public double getItemPrice(int code) throws SQLException {
    ResultSet rs =
        DBConnection.statement.executeQuery(
            "SELECT PRODUCT_PRICE FROM PRODUCTS WHERE CODE = " + code);
    double itemPrice = 0;
    while (rs.next()) {
      itemPrice = rs.getInt("product_price");
    }
    return itemPrice;
  }

  public String productPriceUpdate(int code, double price) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(
            " UPDATE PRODUCTS SET PRODUCT_PRICE = ? WHERE CODE = ?");
    ps.setDouble(1, price);
    ps.setInt(2, code);
    ps.executeUpdate();
    return "Price updated successfully";
  }

  public String productStockUpdate(int code, double stock) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(" UPDATE PRODUCTS SET STOCK = ? WHERE CODE = ?");
    ps.setDouble(1, stock);
    ps.setInt(2, code);
    ps.executeUpdate();
    return "Stock updated successfully";
  }
}
