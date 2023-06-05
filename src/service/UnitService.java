package service;

import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UnitService {
  /**
   * Creates a new unit in the system.
   *
   * @param unit The Unit object representing the unit to be created.
   * @throws SQLException if there is an error executing the database operation.
   */
  void create(Unit unit) throws SQLException;

  /**
   * Edits an existing unit in the system.
   *
   * @param unit The Unit object representing the updated unit information.
   * @throws SQLException if there is an error executing the database operation.
   */
  void edit(Unit unit) throws SQLException;

  /**
   * Deletes the unit with the specified code from the system.
   *
   * @param code The code of the unit to be deleted.
   * @return An Integer indicating the result of the delete operation.
   * @throws SQLException if there is an error executing the database operation.
   */
  Integer delete(String code) throws SQLException;

  /**
   * Retrieves a list of units from the system.
   *
   * @return An ArrayList of Unit objects containing the retrieved units.
   * @throws SQLException if there is an error executing the database operation.
   */
  ArrayList<Unit> list() throws SQLException;
}
