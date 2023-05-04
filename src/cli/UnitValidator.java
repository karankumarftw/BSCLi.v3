package cli;

import modules.unit.UnitCreate;

import java.sql.SQLException;

public class UnitValidator {
	public static String unitCreateValidator(String name,String code,String description,String isDividable) throws SQLException {
		if (name.length() < 3 || name.length() > 30) {
			return "Product name length should be 3 to 30 characters";
		}
		if (code.length() > 5) {
			return "Product code length is maximum 4 characters";
		}
		boolean dividable;
		if(isDividable.equals("true")){
			dividable = true;
		} else if (isDividable.equals("false")) {
			dividable = false;
		}
		else {
			return "isDividable value should be either true or false";
		}
		return UnitCreate.create(name, code, description, dividable);
	}

}
