package service;

import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UnitService {
	String create(Unit unit) throws SQLException;

	String edit(Unit unit) throws SQLException;

	String delete(String code) throws SQLException;

	ArrayList<Unit> list() throws SQLException;
}
