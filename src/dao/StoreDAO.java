package dao;

import entity.Store;
import java.sql.SQLException;

public interface StoreDAO {

  /**
   * Creates a new store record based on the provided Store object.
   *
   * @param store the Store object representing the store to create
   * @throws SQLException if an error occurs during the creation process
   */
  void create(Store store) throws SQLException;

  /**
   * Updates an existing store record based on the provided Store object.
   *
   * @param store the Store object representing the updated store information
   * @throws SQLException if an error occurs during the update process
   */
  void edit(Store store) throws SQLException;

  /**
   * Deletes the store record.
   *
   * @return an Integer representing the result of the deletion operation
   * @throws SQLException if an error occurs during the deletion process
   */
  Integer delete() throws SQLException;
}
