package cliController.unitController;

import entity.Unit;

public class UnitValidator {
  public Unit unitValidator(
      String name, String code, String description, String isDividable)
      throws UnitNotValidException {
		if (name.length() < 3 || name.length() > 30) {
			throw new UnitNotValidException("Unit name length should be 3 to 30 characters");
		
		}
		if (code.length() > 5) {
			throw new UnitNotValidException("Unit code length is maximum 4 characters");
		}
		boolean dividable;
		if (isDividable.equals("true")) {
			dividable = true;
		} else if (isDividable.equals("false")) {
			dividable = false;
		} else {
			throw new UnitNotValidException("isDividable value should be either true or false");
		}
		
		
    return new Unit(name,code,description,dividable);
	}
}
