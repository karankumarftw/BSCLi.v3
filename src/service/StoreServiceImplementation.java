package service;

import dao.StoreDAOImplementation;
import entity.Store;
import java.sql.SQLException;

public class StoreServiceImplementation implements StoreService {
    private StoreDAOImplementation storeDAO = new StoreDAOImplementation();
    private StoreValidator storeValidator = new StoreValidator();

    public String create(Store store) throws Exception {

        try {
            storeValidator.validator(store);
            return storeDAO.create(store);
        } catch (Exception e) {
            throw new StoreNotValidException(e.getMessage());
        }
    }

    public String edit(Store store) throws SQLException, StoreNotValidException {
        try {
            storeValidator.validator(store);
            return storeDAO.edit(store);
        } catch (Exception e) {
            throw new StoreNotValidException(e.getMessage());
        }
    }

    public String delete() throws SQLException {
        return storeDAO.delete();
    }
}
