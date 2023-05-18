package cliController;

import entity.Unit;
import java.sql.SQLException;
import service.UnitService;

public class UnitValidator {
	public static String unitCreateValidator(
			String createOrEdit, String name, String code, String description, String isDividable)
			throws SQLException {
		if (name.length() < 3 || name.length() > 30) {
			return "Product name length should be 3 to 30 characters";
		}
		if (code.length() > 5) {
			return "Product code length is maximum 4 characters";
		}
		boolean dividable;
		if (isDividable.equals("true")) {
			dividable = true;
		} else if (isDividable.equals("false")) {
			dividable = false;
		} else {
			return "isDividable value should be either true or false";
		}
		Unit unit = new Unit(name, code, description, Boolean.parseBoolean(isDividable));
		UnitService unitService = new UnitService();
		if (createOrEdit.equals("create")) {
			return unitService.unitCreate(unit);
		}
		return unitService.unitEdit(unit);
	}
}
