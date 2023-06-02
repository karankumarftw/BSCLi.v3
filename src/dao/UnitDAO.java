package dao;

import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UnitDAO {
  boolean isAvailable(String unitCode) throws SQLException;

  String create(Unit unitObj) throws SQLException;

  String edit(Unit unitObj) throws SQLException;

  String delete(String data) throws SQLException;

  ArrayList<Unit> list() throws SQLException;
}
