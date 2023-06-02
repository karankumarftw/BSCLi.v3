package dao;

import connection.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationDAO {
	public String authentication(String userName,String password) throws SQLException {
		ResultSet rs = DBConnection.statement.executeQuery("select * from users where user_name = '"+userName+"' and user_password = '"+password+"'");
		String userType = null;
		if(rs.next()){
			userType = rs.getString("user_type");
		}
		return userType;
	}
}
