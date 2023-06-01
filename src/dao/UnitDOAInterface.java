package dao;

import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UnitDOAInterface {
  boolean isAvailable(String unitCode) throws SQLException;

  String unitCreate(Unit unitObj) throws SQLException;

  String unitEdit(Unit unitObj) throws SQLException;

  String delete(String data) throws SQLException;

  ArrayList<Unit> list() throws SQLException;
}
