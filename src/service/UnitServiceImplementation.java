package service;

import dao.UnitDAOImplementation;
import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnitServiceImplementation implements UnitService {
	UnitDAOImplementation unitDAO = new UnitDAOImplementation();
	UnitValidator unitValidator = new UnitValidator();

	public String create(Unit unit) throws SQLException {

		try {
			unitValidator.validator(unit);
			return unitDAO.create(unit);
		} catch (UnitNotValidException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String edit(Unit unit) throws SQLException {
		try {
			unitValidator.validator(unit);
			return unitDAO.edit(unit);
		} catch (UnitNotValidException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String delete(String code) throws SQLException {
		return unitDAO.delete(code);
	}

	public ArrayList<Unit> list() throws SQLException {
		return unitDAO.list();
	}
}
