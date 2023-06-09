package dao;

import connection.DBConnection;
import entity.Unit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnitDAOImplementation implements UnitDAO {
  @Override
  public boolean isAvailable(String unitCode) throws SQLException {
    String query = "SELECT * FROM UNIT WHERE UNIT_CODE = '" + unitCode + "'";
    try (ResultSet rs = DBConnection.statement.executeQuery(query)) {
      if (rs.next()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void create(Unit unitObj) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement("INSERT INTO UNIT VALUES (?,?,?,?)");
    ps.setString(1, unitObj.getName());
    ps.setString(2, unitObj.getCode());
    ps.setString(3, unitObj.getDescription());
    ps.setBoolean(4, unitObj.getIsDividable());
    ps.executeUpdate();
  }

  @Override
  public void edit(Unit unitObj) throws SQLException {
    PreparedStatement ps =
        DBConnection.connection.prepareStatement(
            "UPDATE UNIT SET UNIT_NAME = ?, UNIT_DESCRIPTION = ? , UNIT_IS_DIVIDABLE = ? WHERE UNIT_CODE = ?");
    ps.setString(1, unitObj.getName());
    ps.setString(2, unitObj.getDescription());
    ps.setBoolean(3, unitObj.getIsDividable());
    ps.setString(4, unitObj.getCode());
    ps.executeUpdate();
  }

  @Override
  public Integer delete(String data) throws SQLException {
    String query = "DELETE FROM UNIT WHERE UNIT_CODE = '" + data + "'";

    return DBConnection.statement.executeUpdate(query);
  }

  @Override
  public ArrayList<Unit> list() throws SQLException {
    ArrayList<Unit> listOfUnits = new ArrayList<>();
    String query = "SELECT * FROM UNIT ";
    ResultSet rs = DBConnection.statement.executeQuery(query);
    while (rs.next()) {
      String name = rs.getString("unit_name");
      String code = rs.getString("unit_code");
      String description = rs.getString("unit_description");
      boolean isDividable = rs.getBoolean("unit_is_dividable");
      Unit unit = new Unit(name, code, description, isDividable);
      listOfUnits.add(unit);
    }
    return listOfUnits;
  }
}
