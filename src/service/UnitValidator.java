package service;

import entity.Unit;

public class UnitValidator {

  /**
   * Validates the given unit.
   *
   * @param unit The unit to be validated.
   * @throws UnitNotValidException If the unit is not valid according to business rules.
   */
  public void validator(Unit unit) throws UnitNotValidException {

    String name = unit.getName();
    String code = unit.getCode();
    String isDividable = String.valueOf(unit.getIsDividable());
    if (name.length() < 3 || name.length() > 30) {
      throw new UnitNotValidException("Unit name length should be 3 to 30 characters");
    }
    if (code.length() > 5) {
      throw new UnitNotValidException("Unit code length is maximum 4 characters");
    }
    if (isDividable.equals("true") || isDividable.equals("false")) {
      return;
    } else {
      throw new UnitNotValidException("isDividable value should be either true or false");
    }
  }
}
