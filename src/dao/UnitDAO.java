package dao;

import connection.DBConnection;
import entity.Unit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitDAO implements Delete, DefaultList, UnitCreate {
    public static boolean isAvailable(String unitCode) throws SQLException {
        String query = "select * from unit where unit_code = '" + unitCode + "'";
        try (ResultSet rs = DBConnection.statement.executeQuery(query)) {
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String unitCreate(Unit unitObj) throws SQLException {
        PreparedStatement ps =
                DBConnection.connection.prepareStatement("insert into unit values (?,?,?,?)");
        ps.setString(1, unitObj.getCode());
        ps.setString(2, unitObj.getName());
        ps.setString(3, unitObj.getDescription());
        ps.setBoolean(4, unitObj.getIsDividable());
        ps.executeUpdate();
        return "Unit created Successfully";
    }

    public String unitEdit(Unit unitObj) throws SQLException {
        PreparedStatement ps =
                DBConnection.connection.prepareStatement(
                        "update unit set unit_name = ?, description = ? , is_dividable = ? where unit_code = ?");
        ps.setString(1, unitObj.getName());
        ps.setString(2, unitObj.getDescription());
        ps.setBoolean(3, unitObj.getIsDividable());
        ps.setString(4, unitObj.getCode());
        ps.executeUpdate();
        return "Unit edited Successfully";
    }

    @Override
    public String delete(String data) throws SQLException {
        String query = "delete from unit where unit_code = '" + data + "'";
        DBConnection.statement.execute(query);
        return "Unit deleted successfully";
    }

    @Override
    public ResultSet list() throws SQLException {
        String query = "select * from unit ";
        return DBConnection.statement.executeQuery(query);
    }
}
