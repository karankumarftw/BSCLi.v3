package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DefaultList {
	ResultSet list() throws SQLException;
}
