package service;

import dao.UnitDAO;
import entity.Unit;

import java.sql.SQLException;
import java.util.ArrayList;

public class UnitService {
	UnitDAO unitDAO = new UnitDAO();

	public String unitCreate(Unit unit) throws SQLException {
		return unitDAO.unitCreate(unit);
	}

	public String unitEdit(Unit unit) throws SQLException {
		return unitDAO.unitEdit(unit);
	}

	public String unitDelete(String code) throws SQLException {
		return unitDAO.delete(code);
	}

	public ArrayList<Unit> unitList() throws SQLException {
		return unitDAO.list();
	}
}
