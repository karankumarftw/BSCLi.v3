package modules.unit;

import dao.UnitDAO;
import entity.Unit;

import java.sql.SQLException;

public class UnitCreate {
  public static String create(
      String unitCode, String unitName, String description, boolean isDividable)
      throws SQLException {
    Unit unit = new Unit(unitCode, unitName, description, isDividable);
    UnitDAO unitDaoObj = new UnitDAO();
    return unitDaoObj.unitCreate(unit);
  }
}
