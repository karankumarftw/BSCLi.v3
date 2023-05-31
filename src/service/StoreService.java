package service;

import dao.StoreDAO;
import entity.Store;
import java.sql.SQLException;

public class StoreService {
    private StoreDAO storeDAO = new StoreDAO();
    private StoreValidator storeValidator = new StoreValidator();

    public String createStore(Store store) throws Exception {

        try {
            storeValidator.storeValidator(store);
            return storeDAO.createStore(store);
        } catch (Exception e) {
            throw new StoreNotValidException(e.getMessage());
        }
    }

    public String editStore(Store store) throws SQLException, StoreNotValidException {
        try {
            storeValidator.storeValidator(store);
            return storeDAO.editStore(store);
        } catch (Exception e) {
            throw new StoreNotValidException(e.getMessage());
        }
    }

    public String deleteStore() throws SQLException {
        return storeDAO.deleteStore();
    }
}
