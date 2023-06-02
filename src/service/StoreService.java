package service;

import entity.Store;
import java.sql.SQLException;

public interface StoreService {
  String create(Store store) throws Exception;

  String edit(Store store) throws SQLException, StoreNotValidException;

  String delete() throws SQLException;
}
