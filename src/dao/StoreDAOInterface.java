package dao;

import entity.Store;
import java.sql.SQLException;

public interface StoreDAOInterface {
  String createStore(Store store) throws SQLException;

  String editStore(Store store) throws SQLException;

  String deleteStore() throws SQLException;
}
