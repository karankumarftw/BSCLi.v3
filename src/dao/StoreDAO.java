package dao;

import entity.Store;
import java.sql.SQLException;

public interface StoreDAO {
  String create(Store store) throws SQLException;

  String edit(Store store) throws SQLException;

  String delete() throws SQLException;
}
