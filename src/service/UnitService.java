package service;

import dao.UnitDAO;
import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnitService implements UnitServiceInterface {
  UnitDAO unitDAO = new UnitDAO();
  UnitValidator unitValidator = new UnitValidator();

  public String unitCreate(Unit unit) throws SQLException {

    try {
      unitValidator.unitValidator(unit);
      return unitDAO.unitCreate(unit);
    } catch (UnitNotValidException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public String unitEdit(Unit unit) throws SQLException {
    try {
      unitValidator.unitValidator(unit);
      return unitDAO.unitEdit(unit);
    } catch (UnitNotValidException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public String unitDelete(String code) throws SQLException {
    return unitDAO.delete(code);
  }

  public ArrayList<Unit> unitList() throws SQLException {
    return unitDAO.list();
  }
}
