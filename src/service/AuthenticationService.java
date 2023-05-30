package service;

import dao.AuthenticationDAO;

import java.sql.SQLException;

public class AuthenticationService {
    AuthenticationDAO authenticationDAO = new AuthenticationDAO();
    public String authenticate(String userName, String password) throws SQLException {
        return authenticationDAO.authentication(userName,password);
    }
}
