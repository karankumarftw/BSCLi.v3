package dao;

import connection.DBConnection;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO implements ProductCreate, Delete, DefaultList {
  @Override
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

  @Override
  public String delete(String data) throws SQLException {
    String query = "delete from products where code = " + data;
    DBConnection.statement.execute(query);
    return "Product deleted successfully";
  }

  @Override
  public ResultSet list() throws SQLException {
    String query = "select * from products order by code limit 20";
    return DBConnection.statement.executeQuery(query);
  }

  public ResultSet listWithPageLimit(int limitCount) throws SQLException {
    String query = "select * from products order by code limit " + limitCount;
    return DBConnection.statement.executeQuery(query);
  }

  public ResultSet listWithPageLimitAndPageCount(int pageLimit, int pageCount) throws SQLException {
    int offset;
    if (pageCount == 1) {
      offset = 0;
    } else {
      offset = (pageCount - 1) * pageLimit;
    }
    String query =
        "select * from products order by code asc offset " + offset + "  limit " + pageLimit;
    return DBConnection.statement.executeQuery(query);
  }
}
