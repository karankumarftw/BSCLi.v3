package service;

import dao.StoreDAO;
import entity.Store;
import java.sql.SQLException;

public class StoreService {
  private StoreDAO storeDAO = new StoreDAO();

  public String createStore(Store store) throws SQLException {
    return storeDAO.createStore(store);
  }

  public String editStore(Store store) throws SQLException {
    return storeDAO.editStore(store);
  }
}
