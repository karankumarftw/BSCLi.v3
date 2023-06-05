package dao;

import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UnitDAO {
  /**
   * Checks if a unit with the specified unit code is available.
   *
   * @param unitCode the unit code to check availability for
   * @return true if the unit is available, false otherwise
   * @throws SQLException if an error occurs while checking the availability
   */
  boolean isAvailable(String unitCode) throws SQLException;

  /**
   * Creates a new unit record based on the provided Unit object.
   *
   * @param unitObj the Unit object representing the unit to create
   * @throws SQLException if an error occurs during the creation process
   */
  void create(Unit unitObj) throws SQLException;

  /**
   * Updates an existing unit record based on the provided Unit object.
   *
   * @param unitObj the Unit object representing the updated unit information
   * @throws SQLException if an error occurs during the update process
   */
  void edit(Unit unitObj) throws SQLException;

  /**
   * Deletes a unit record based on the provided data.
   *
   * @param data the data used to identify the unit to delete
   * @return an Integer representing the result of the deletion operation
   * @throws SQLException if an error occurs during the deletion process
   */
  Integer delete(String data) throws SQLException;

  /**
   * Retrieves a list of units.
   *
   * @return an ArrayList containing the list of Unit objects representing the units
   * @throws SQLException if an error occurs while retrieving the list
   */
  ArrayList<Unit> list() throws SQLException;
}
