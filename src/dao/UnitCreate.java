package dao;

import entity.Unit;
import java.sql.SQLException;

public interface UnitCreate {
	String unitCreate(Unit unitObj) throws SQLException;
}
