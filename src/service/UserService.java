package service;

import dao.UserDAO;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public String userDelete(int userID) throws SQLException {
        return userDAO.delete(String.valueOf(userID));
    }

    public String userCreate(User user) throws SQLException {
        return userDAO.createUser(user);
    }

    public String userEdit(User user) throws SQLException {
        return userDAO.editUser(user);
    }

    public ArrayList<User> userList() throws SQLException {
        return userDAO.list();
    }
}
