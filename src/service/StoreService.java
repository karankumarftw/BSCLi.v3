package service;

import entity.Store;
import java.sql.SQLException;

public interface StoreService {
  /**
   * Creates a new store in the system.
   *
   * @param store The Store object representing the store to be created.
   * @throws Exception if there is an error creating the store.
   */
  void create(Store store) throws Exception;

  /**
   * Edits an existing store in the system.
   *
   * @param store The Store object representing the updated store information.
   * @throws SQLException if there is an error executing the database operation.
   * @throws StoreNotValidException if the store object does not meet the required validation
   *     criteria.
   */
  void edit(Store store) throws SQLException, StoreNotValidException;

  /**
   * Deletes the store from the system.
   *
   * @return An Integer indicating the result of the delete operation.
   * @throws SQLException if there is an error executing the database operation.
   */
  Integer delete() throws SQLException;
}
