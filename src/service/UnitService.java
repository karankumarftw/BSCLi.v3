package service;

import dao.UnitDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitService {
  public String unitDelete(String code) throws SQLException {
    UnitDAO unitDAO = new UnitDAO();
    return unitDAO.delete(code);
  }

  public ResultSet unitList() throws SQLException {
    UnitDAO unitDAO = new UnitDAO();
    return unitDAO.list();
  }
}
