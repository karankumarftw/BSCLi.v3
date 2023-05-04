package dao;
import interfaces.Delete;
import interfaces.defaultList;
import interfaces.UnitCreate;
import entity.Unit;
import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitDAO implements Delete , defaultList , UnitCreate{
	@Override
	public String unitCreate(Unit unitObj) throws SQLException {
		PreparedStatement ps = DBConnection.connection.prepareStatement("insert into unit values (?,?,?,?)");
		ps.setString(1, unitObj.getCode());
		ps.setString(2, unitObj.getName());
		ps.setString(3, unitObj.getDescription());
		ps.setBoolean(4, unitObj.getIsDividable());
		ps.executeUpdate();
		return "Unit created Successfully";
	}

	@Override
	public String delete(String code) throws SQLException {
		String query = "delete from unit where unit_code = '"+code+"'";
		DBConnection.statement.execute(query);
		return "Unit deleted successfully";
	}
	public static boolean isAvailable(String unitCode) throws SQLException {
		String query = "select * from unit where unit_code = '"+unitCode+"'";
		try (ResultSet rs = DBConnection.statement.executeQuery(query)) {
			if (rs.next()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ResultSet list() throws SQLException {
		String query = "select * from unit ";
		return DBConnection.statement.executeQuery(query);
	}
}