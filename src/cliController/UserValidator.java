package cliController;

import entity.User;
import java.sql.SQLException;
import service.UserService;

public class UserValidator {
  static String userValidator(
          int id,
      String userType,
      String userName,
      String userPassword,
      String userFirstName,
      String userLastName,
      String userPhoneNumber)
      throws SQLException {
    if (!userType.equals("sales") && !userType.equals("purchase")) {
      return "User Type either should be sales or purchase";
    }

    if (userName.length() > 30 || userName.length() < 3) {
      return "User name length should be between 3 to 30 characters";
    }

    if (userPassword.length() < 8) {
      return "Password length should be minimum of 8 characters";
    }

    if (userFirstName.length() < 3 || userFirstName.length() > 30) {
      return "First name length should be  between 3 to 30 characters";
    }

    if (userPhoneNumber.length() != 10) {
      return "Phone number should be 10 digits";
    }

    if (!(userPhoneNumber.charAt(0) == '9'
        || userPhoneNumber.charAt(0) == '8'
        || userPhoneNumber.charAt(0) == '7'
        || userPhoneNumber.charAt(0) == '6')) {
      return "Invalid phone number, The number should start with either one of these, 9,8,7,6";
    }

    User user =
        new User(
                id,
            userType,
            userName,
            userPassword,
            userFirstName,
            userLastName,
            Long.parseLong(userPhoneNumber));
    UserService userService = new UserService();
    return userService.createUser(user);
  }
}
