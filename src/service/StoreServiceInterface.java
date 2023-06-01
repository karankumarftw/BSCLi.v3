package service;

import entity.Store;
import java.sql.SQLException;

public interface StoreServiceInterface {
  String createStore(Store store) throws Exception;

  String editStore(Store store) throws SQLException, StoreNotValidException;

  String deleteStore() throws SQLException;
}
