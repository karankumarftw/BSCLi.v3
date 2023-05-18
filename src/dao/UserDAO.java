package dao;

import connection.DBConnection;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements Delete {

    @Override
    public String delete(String data) throws SQLException {
        String query = "delete from users where id = " + data;
        DBConnection.statement.execute(query);
        return "User deleted successfully";
    }

    public String createUser(User user) throws SQLException {
        PreparedStatement ps =
                DBConnection.connection.prepareStatement(
                        "insert into users (user_type,user_name,user_password,user_firstname,user_lastname,user_phonenumber) values (?,?,?,?,?,?)");
        ps.setString(1, user.getUserType());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getFirstName());
        ps.setString(5, user.getLastName());
        ps.setLong(6, user.getUserPhoneNumber());
        ps.executeUpdate();
        return "New user created successfully";
    }

    public String editUser(User user) throws SQLException {
        PreparedStatement ps =
                DBConnection.connection.prepareStatement(
                        "update users set user_type = ? ,password = ? ,first_name = ? ,last_name = ? ,phone_number = ? where user_name = ? ");
        ps.setString(1, user.getUserType());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getFirstName());
        ps.setString(4, user.getLastName());
        ps.setLong(5, user.getUserPhoneNumber());
        ps.setString(6, user.getUserName());
        ps.executeUpdate();
        return "user Edit successfully";
    }


    public ArrayList<User> list() throws SQLException {
        ArrayList<User> listOfUsers = new ArrayList<>();
        String query = "select * from users order by id limit 20";
        ResultSet rs = DBConnection.statement.executeQuery(query);
        while(rs.next()){

            int id = rs.getInt("id");
            String userType = rs.getString("user_type");
            String userName = rs.getString("user_name");
            String firstName = rs.getString("user_firstname");
            String password = rs.getString("user_password");
            String lastName = rs.getString("user_lastname");
            long phoneNumber = rs.getLong("user_phonenumber");
            User user = new User(id,userType,userName,password,firstName,lastName,phoneNumber);
            listOfUsers.add(user);
        }

        return listOfUsers;
    }
}
