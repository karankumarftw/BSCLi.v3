package service;

import dao.StoreDAOImplementation;
import entity.Store;
import java.sql.SQLException;

public class StoreServiceImplementation implements StoreService {
  private StoreDAOImplementation storeDAO = new StoreDAOImplementation();
  private StoreValidator storeValidator = new StoreValidator();

  public void create(Store store) throws Exception {
    try {
      storeValidator.validator(store);

    } catch (Exception e) {
      throw new StoreNotValidException(e.getMessage());
    }
  }

  public void edit(Store store) throws SQLException, StoreNotValidException {
    try {
      storeValidator.validator(store);
    } catch (Exception e) {
      throw new StoreNotValidException(e.getMessage());
    }
  }

  public Integer delete() throws SQLException {
    return storeDAO.delete();
  }
}
