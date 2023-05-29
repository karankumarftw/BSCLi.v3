package dao;

import connection.DBConnection;
import entity.Store;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreDAO {
	public String createStore(Store store) throws SQLException {
		try{
			PreparedStatement ps =
					DBConnection.connection.prepareStatement("insert into store values (?,?,?,?)");
			ps.setString(1, store.getStoreName());
			ps.setLong(2, store.getPhoneNumber());
			ps.setString(3, store.getAddress());
			ps.setString(4, store.getGstNumber());
			ps.executeUpdate();
			return "Store created Successfully";
		}
		catch (SQLException e){
			throw new SQLException("The store name already exists");
		}
	}

	public String editStore(Store store) throws SQLException {
		PreparedStatement ps =
				DBConnection.connection.prepareStatement("update store set store_phone_number = ?, store_address = ?, store_gst_number = ? where store_name = ?");

		ps.setLong(1, store.getPhoneNumber());
		ps.setString(2, store.getAddress());
		ps.setString(3, store.getGstNumber());
		ps.setString(4, store.getStoreName());
		ps.executeUpdate();
		return "Store edited Successfully";
	}
}
