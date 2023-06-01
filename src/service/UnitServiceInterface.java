package service;

import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UnitServiceInterface {
  String unitCreate(Unit unit) throws SQLException;

  String unitEdit(Unit unit) throws SQLException;

  String unitDelete(String code) throws SQLException;

  ArrayList<Unit> unitList() throws SQLException;
}
